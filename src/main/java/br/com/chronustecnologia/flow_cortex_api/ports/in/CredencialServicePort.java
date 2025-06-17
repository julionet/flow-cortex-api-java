package br.com.chronustecnologia.flow_cortex_api.ports.in;

import br.com.chronustecnologia.flow_cortex_api.dto.TokenRequest;
import br.com.chronustecnologia.flow_cortex_api.dto.TokenResponse;
import org.springframework.stereotype.Service;

@Service
public interface CredencialServicePort {
    TokenResponse authenticate(TokenRequest request);
}
