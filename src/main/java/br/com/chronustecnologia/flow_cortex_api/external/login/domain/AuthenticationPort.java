package br.com.chronustecnologia.flow_cortex_api.external.login.domain;

public interface AuthenticationPort {
    LoginResponse authenticate(LoginRequest loginRequest) throws AuthenticationException;
}
