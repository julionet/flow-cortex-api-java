package br.com.chronustecnologia.flow_cortex_api.ports.in;

import br.com.chronustecnologia.flow_cortex_api.dto.credencial.TokenRequest;
import br.com.chronustecnologia.flow_cortex_api.dto.credencial.TokenResponse;

public interface CredencialServicePort {
    TokenResponse authenticate(TokenRequest request);
}
