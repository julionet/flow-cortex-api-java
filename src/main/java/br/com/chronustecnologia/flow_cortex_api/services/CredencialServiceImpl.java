package br.com.chronustecnologia.flow_cortex_api.services;

import br.com.chronustecnologia.flow_cortex_api.config.DatabaseInitializer;
import br.com.chronustecnologia.flow_cortex_api.domain.Credencial;
import br.com.chronustecnologia.flow_cortex_api.dto.TokenRequest;
import br.com.chronustecnologia.flow_cortex_api.dto.TokenResponse;
import br.com.chronustecnologia.flow_cortex_api.exceptions.BadRequestException;
import br.com.chronustecnologia.flow_cortex_api.ports.in.CredencialServicePort;
import br.com.chronustecnologia.flow_cortex_api.ports.out.CredencialRepositoryPort;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class CredencialServiceImpl implements CredencialServicePort {
    private static final Logger logger = LoggerFactory.getLogger(CredencialServiceImpl.class);
    private final CredencialRepositoryPort credencialRepository;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public CredencialServiceImpl(CredencialRepositoryPort credencialRepository) {
        this.credencialRepository = credencialRepository;
    }

    @Override
    public TokenResponse authenticate(TokenRequest request) {
        if (!"client_credentials".equals(request.getGrant_type())) {
            logger.error("Grant type não suportado");
            throw new BadRequestException("Grant type não suportado");
        }

        Credencial credencial = credencialRepository.getByClientIdAndActive(request.getClient_id())
                .orElseThrow(() -> new BadRequestException("Cliente não encontrado"));

        if (!request.getClient_secret().equals(credencial.getClientSecret())) {
            logger.error("Credenciais inválidas");
            throw new BadRequestException("Credenciais inválidas");
        }

        if (!Arrays.asList(credencial.getGrantTypes().split(",")).contains(request.getGrant_type())) {
            logger.error("Grant type não permitido para este cliente");
            throw new BadRequestException("Grant type não permitido para este cliente");
        }

        String validatedScope = validateScopes(request.getScope(), credencial.getScopes());

        String token = generateToken(credencial.getClientId(), validatedScope);

        return new TokenResponse(token, "Bearer", expiration, validatedScope);
    }

    private String generateToken(String clientId, String scope) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + expiration);

        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .subject(clientId)
                .claim("scope", scope)
                .claim("token_type", "Bearer")
                .issuedAt(now)
                .expiration(expiry)
                .signWith(key, Jwts.SIG.HS256)
                .compact();
    }

    private String validateScopes(String requestedScopes, String allowedScopes) {
        if (requestedScopes == null || requestedScopes.trim().isEmpty()) {
            return "read";
        }

        Set<String> allowed = new HashSet<>(Arrays.asList(allowedScopes.split(",")));
        Set<String> requested = new HashSet<>(Arrays.asList(requestedScopes.split(" ")));

        requested.retainAll(allowed);

        if (requested.isEmpty()) {
            logger.error("Nenhum scope válido solicitado");
            throw new RuntimeException("Nenhum scope válido solicitado");
        }

        return String.join(" ", requested);
    }
}
