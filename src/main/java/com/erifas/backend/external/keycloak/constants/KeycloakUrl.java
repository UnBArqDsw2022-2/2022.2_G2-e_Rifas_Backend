package com.erifas.backend.external.keycloak.constants;

public enum KeycloakUrl {
    URL_GET_USERS("/admin/realms/{realm}/users");
    private String url;
    KeycloakUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
