package br.com.chronustecnologia.flow_cortex_api.controller;

import br.com.chronustecnologia.flow_cortex_api.dto.credencial.TokenRequest;
import br.com.chronustecnologia.flow_cortex_api.dto.credencial.TokenResponse;
import br.com.chronustecnologia.flow_cortex_api.ports.in.CredencialServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(
        name = "OAuth 2.0 Authentication",
        description = "Endpoints para autenticação OAuth 2.0 com Client Credentials Grant")
public class AuthController {
    private final CredencialServicePort credencialService;

    public AuthController(CredencialServicePort credencialService) {
        this.credencialService = credencialService;
    }

    @Operation(
            summary = "Obter um novo JWT token",
            description = "Gera um token JWT usando o fluxo OAuth 2.0 Client Credentials Grant",
            operationId = "generateToken"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Token gerado com sucesso",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = TokenResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erro na requisição - credenciais inválidas ou scopes não permitidos",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = TokenResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor",
                    content = @Content
            )
    })
    @PostMapping(value = "/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<TokenResponse> token(@Valid @ModelAttribute TokenRequest request) {
        TokenResponse response = credencialService.authenticate(request);
        return ResponseEntity.ok(response);
    }
}
