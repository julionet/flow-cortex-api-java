package br.com.chronustecnologia.flow_cortex_api.config;

import br.com.chronustecnologia.flow_cortex_api.domain.Credencial;
import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.Collections;

public class ClientAuthenticationToken extends AbstractAuthenticationToken {

    private final Credencial credencial;
    private final String scope;

    public ClientAuthenticationToken(Credencial credencial, String scope) {
        super(Collections.emptyList()); // Clients não têm authorities como usuários
        this.credencial = credencial;
        this.scope = scope;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return credencial;
    }

    public String getScope() {
        return scope;
    }

    public String getClientId() {
        return credencial.getClientId();
    }
}
