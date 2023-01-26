package com.erifas.backend.external.keycloak.service;

import com.erifas.backend.constants.ApplicationProperties;
import com.erifas.backend.external.keycloak.constants.KeycloakUrl;
import com.erifas.backend.external.keycloak.dto.Token;
import com.erifas.backend.external.keycloak.dto.User;
import com.erifas.backend.persistence.model.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class KeycloakService {
    private final KeycloakTokenComponent keycloakTokenComponent;
    private final ApplicationProperties.KeycloakConfigurationProperties keycloakConfigurationProperties;
    private final ApplicationProperties.KeycloakProperties keycloakProperties;


    Logger logger = LoggerFactory.getLogger(KeycloakService.class);


    public KeycloakService(KeycloakTokenComponent keycloakTokenComponent, ApplicationProperties.KeycloakConfigurationProperties keycloakConfigurationProperties, ApplicationProperties.KeycloakProperties keycloakProperties) {
        this.keycloakTokenComponent = keycloakTokenComponent;
        this.keycloakConfigurationProperties = keycloakConfigurationProperties;
        this.keycloakProperties = keycloakProperties;
    }

    public Optional<List<User>> getUsers() {
        Optional<Token> authorizationToken = keycloakTokenComponent.getAuthorizationToken();
        if (authorizationToken.isPresent()) {
            Token token = authorizationToken.get();
            return Optional.ofNullable(Objects.requireNonNull(getWebClientBuilderForRequests(token.getAcessToken())
                    .get()
                    .uri(KeycloakUrl.URL_USERS.getUrl(), keycloakProperties.getRealm())
                    .retrieve()
                    .toEntityList(User.class)
                    .block()).getBody());
        } else {
            return Optional.empty();
        }
    }


    public Optional<HttpStatusCode> deleteUser(String userId) {
        Optional<Token> authorizationToken = keycloakTokenComponent.getAuthorizationToken();
        if (authorizationToken.isPresent()) {
            Token token = authorizationToken.get();
            return Optional.of(Objects.requireNonNull(getWebClientBuilderForRequests(token.getAcessToken())
                    .delete()
                    .uri(KeycloakUrl.URL_USER_ID.getUrl(), keycloakProperties.getRealm(), userId)
                    .retrieve()
                    .toBodilessEntity()
                    .block()).getStatusCode());
        }
        return Optional.empty();
    }

    public Optional<Usuario> getUser(String id) {
        Optional<Token> authorizationToken = keycloakTokenComponent.getAuthorizationToken();
        if (authorizationToken.isPresent()) {
            Token token = authorizationToken.get();
            return Optional.ofNullable(Objects.requireNonNull(getWebClientBuilderForRequests(token.getAcessToken())
                    .get()
                    .uri(KeycloakUrl.URL_USER_ID.getUrl(), keycloakProperties.getRealm(), id)
                    .retrieve()
                    .toEntity(Usuario.class)
                    .block()).getBody());
        }
        return Optional.empty();
    }

    private WebClient getWebClientBuilderForRequests(String token) {
        return WebClient.builder().baseUrl(keycloakProperties.getAuthServerUrl()).defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).defaultHeader("Authorization", "bearer " + token).build();
    }

}
