package com.erifas.backend.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {
    @Component
    @ConfigurationProperties("keycloak")
    public static class KeycloakProperties {
        private String realm;
        private String resource;
        private String publicClient;
        private String sslRequired;
        private String authServerUrl;

        public String getRealm() {
            return realm;
        }

        public void setRealm(String realm) {
            this.realm = realm;
        }

        public String getResource() {
            return resource;
        }

        public void setResource(String resource) {
            this.resource = resource;
        }

        public String getPublicClient() {
            return publicClient;
        }

        public void setPublicClient(String publicClient) {
            this.publicClient = publicClient;
        }

        public String getSslRequired() {
            return sslRequired;
        }

        public void setSslRequired(String sslRequired) {
            this.sslRequired = sslRequired;
        }

        public String getAuthServerUrl() {
            return authServerUrl;
        }

        public void setAuthServerUrl(String authServerUrl) {
            this.authServerUrl = authServerUrl;
        }
    }

    @Component
    @ConfigurationProperties("keycloak-configuration")
    public static class KeycloakConfigurationProperties {
        private String tokenUrl;
        private String clientSecret;

        public String getTokenUrl() {
            return tokenUrl;
        }

        public void setTokenUrl(String tokenUrl) {
            this.tokenUrl = tokenUrl;
        }

        public String getClientSecret() {
            return clientSecret;
        }

        public void setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
        }
    }
}
