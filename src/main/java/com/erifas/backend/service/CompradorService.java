package com.erifas.backend.service;

import com.erifas.backend.external.keycloak.service.KeycloakService;
import com.erifas.backend.persistence.model.Comprador;
import com.erifas.backend.persistence.model.Usuario;
import com.erifas.backend.repository.jpa.core.CompradorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CompradorService {

    private final CompradorRepository compradorRepository;
    private final KeycloakService keycloakService;


    public CompradorService(CompradorRepository compradorRepository, KeycloakService keycloakService) {
        this.compradorRepository = compradorRepository;
        this.keycloakService = keycloakService;
    }

    public Optional<Comprador> save(Comprador comprador) {
        Optional<Usuario> user = keycloakService.getUser(comprador.getUsuario().getId());
        if (user.isPresent()) {
            comprador.setUsuario(user.get());
            return Optional.of(compradorRepository.save(comprador));
        }
        return Optional.of(compradorRepository.save(comprador));
    }

    public Optional<Comprador> getCompradorByUserId(String id) {
        Optional<Usuario> user = keycloakService.getUser(id);
        if (user.isPresent()) {
            return Optional.of(compradorRepository.findCompradorByUsuario(user.get()));
        }
        return Optional.empty();
    }
}
