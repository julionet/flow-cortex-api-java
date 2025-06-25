package br.com.chronustecnologia.flow_cortex_api.external.login.application;

import br.com.chronustecnologia.flow_cortex_api.external.login.domain.AuthenticationException;
import br.com.chronustecnologia.flow_cortex_api.external.login.domain.AuthenticationPort;
import br.com.chronustecnologia.flow_cortex_api.external.login.domain.LoginRequest;
import br.com.chronustecnologia.flow_cortex_api.external.login.domain.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationUseCase {

    private final AuthenticationPort authenticationPort;

    public AuthenticationUseCase(AuthenticationPort authenticationPort) {
        this.authenticationPort = authenticationPort;
    }

    public LoginResponse login(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new AuthenticationException("Username não pode estar vazio");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new AuthenticationException("Password não pode estar vazio");
        }

        LoginRequest request = new LoginRequest(username, password);
        return authenticationPort.authenticate(request);
    }
}
