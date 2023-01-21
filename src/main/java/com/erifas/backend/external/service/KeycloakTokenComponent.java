package com.erifas.backend.external.service;

import com.erifas.backend.constants.ApplicationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class KeycloakTokenComponent {

    Logger logger = LoggerFactory.getLogger(KeycloakTokenComponent.class);

    private final ApplicationProperties.KeycloakProperties keycloakProperties;

    public KeycloakTokenComponent(ApplicationProperties.KeycloakProperties keycloakProperties) {
        this.keycloakProperties = keycloakProperties;
    }



}
