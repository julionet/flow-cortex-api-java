package br.com.chronustecnologia.flow_cortex_api.external.login.infrastructure;

import br.com.chronustecnologia.flow_cortex_api.external.login.domain.AuthenticationException;
import br.com.chronustecnologia.flow_cortex_api.external.login.domain.AuthenticationPort;
import br.com.chronustecnologia.flow_cortex_api.external.login.domain.LoginRequest;
import br.com.chronustecnologia.flow_cortex_api.external.login.domain.LoginResponse;
import feign.FeignException;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationAdapter implements AuthenticationPort {

    private final AuthFeignClient authFeignClient;

    public AuthenticationAdapter(AuthFeignClient authFeignClient) {
        this.authFeignClient = authFeignClient;
    }

    @Override
    public LoginResponse authenticate(LoginRequest loginRequest) throws AuthenticationException {
        try {
            return authFeignClient.login(loginRequest);
        } catch (FeignException e) {
            throw new AuthenticationException("Falha na autenticação: " + e.getMessage(), e);
        }
    }
}
