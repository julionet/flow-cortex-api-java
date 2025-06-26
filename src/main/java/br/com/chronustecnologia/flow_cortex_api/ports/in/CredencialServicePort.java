package br.com.chronustecnologia.flow_cortex_api.ports.in;

import br.com.chronustecnologia.flow_cortex_api.domain.Credencial;
import br.com.chronustecnologia.flow_cortex_api.dto.credencial.TokenRequest;
import br.com.chronustecnologia.flow_cortex_api.dto.credencial.TokenResponse;

import java.util.Optional;

public interface CredencialServicePort {
    TokenResponse authenticate(TokenRequest request);
    Optional<Credencial> getByClientId(String clientId);
}
