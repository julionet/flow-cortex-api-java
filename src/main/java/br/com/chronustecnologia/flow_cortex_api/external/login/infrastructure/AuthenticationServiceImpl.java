package br.com.chronustecnologia.flow_cortex_api.external.login.infrastructure;

import br.com.chronustecnologia.flow_cortex_api.external.login.domain.AuthenticationException;
import br.com.chronustecnologia.flow_cortex_api.external.login.domain.AuthenticationServicePort;
import br.com.chronustecnologia.flow_cortex_api.external.login.domain.LoginRequest;
import br.com.chronustecnologia.flow_cortex_api.external.login.domain.LoginResponse;
import feign.FeignException;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
public class AuthenticationServiceImpl implements AuthenticationServicePort {

    private final AuthFeignClient authFeignClient;

    public AuthenticationServiceImpl(AuthFeignClient authFeignClient) {
        this.authFeignClient = authFeignClient;
    }

    @Override
    public LoginResponse authenticate(LoginRequest loginRequest) throws AuthenticationException {
        try {
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("username", loginRequest.getUsername());
            formData.add("password", loginRequest.getPassword());
            return authFeignClient.login(formData);
        } catch (FeignException e) {
            throw new AuthenticationException("Falha na autenticação: " + e.getMessage(), e);
        }
    }
}
