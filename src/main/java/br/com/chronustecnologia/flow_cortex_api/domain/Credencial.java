package br.com.chronustecnologia.flow_cortex_api.domain;

public class Credencial {
    private Long id;
    private String clientId;
    private String clientSecret;
    private String grantTypes;
    private String scopes;
    private boolean active;

    public Credencial() {

    }

    public Credencial(Long id, String clientId, String clientSecret, String grantTypes, String scopes, boolean active) {
        this.id = id;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.grantTypes = grantTypes;
        this.scopes = scopes;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(String grantTypes) {
        this.grantTypes = grantTypes;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
