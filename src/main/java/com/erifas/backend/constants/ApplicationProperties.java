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
    }

    @ConfigurationProperties("keycloakConfiguration")
}
