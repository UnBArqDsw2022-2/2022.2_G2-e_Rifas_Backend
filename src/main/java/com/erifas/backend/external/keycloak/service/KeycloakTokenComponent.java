package com.erifas.backend.external.keycloak.service;

import com.erifas.backend.constants.ApplicationProperties;
import com.erifas.backend.external.keycloak.dto.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Optional;

@Component
public class KeycloakTokenComponent {

    Logger logger = LoggerFactory.getLogger(KeycloakTokenComponent.class);

    private final ApplicationProperties.KeycloakProperties keycloakProperties;
    private final ApplicationProperties.KeycloakConfigurationProperties keycloakConfigurationProperties;


    public KeycloakTokenComponent(ApplicationProperties.KeycloakProperties keycloakProperties, ApplicationProperties.KeycloakConfigurationProperties keycloakConfigurationProperties) {
        this.keycloakProperties = keycloakProperties;
        this.keycloakConfigurationProperties = keycloakConfigurationProperties;
    }

    public Optional<Token> getAuthorizationToken() {
        try {

            return Optional.of(getRequisicaoToken());

        } catch (WebClientResponseException e) {

            logger.error("Erro ao realizar requisição " + e.getMessage());

        }

        return Optional.empty();
    }

    private Token getRequisicaoToken() throws WebClientResponseException {
        return getWebClientBuilderForToken().post().uri(keycloakConfigurationProperties.getTokenUrl(), keycloakProperties.getRealm())
                .body(BodyInserters.fromFormData("client_id", keycloakProperties.getResource())
                        .with("client_secret", keycloakConfigurationProperties.getClientSecret())
                        .with("grant_type", "client_credentials"))
                .retrieve()
                .bodyToMono(Token.class).block();
    }

    private WebClient getWebClientBuilderForToken() {
        return WebClient.builder()
                .baseUrl(keycloakProperties.getAuthServerUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

}
