package com.erifas.backend.external.keycloak.constants;

public enum KeycloakUrl {
    URL_USERS("/admin/realms/{realm}/users"),
    URL_USER_ID("/admin/realms/{realm}/users/{id}");

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
