package com.erifas.backend.service;

import com.erifas.backend.external.keycloak.dto.User;
import com.erifas.backend.external.keycloak.service.KeycloakService;
import com.erifas.backend.repository.jpa.core.UsuarioRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final KeycloakService keycloakService;


    public UsuarioService(UsuarioRepository usuarioRepository, KeycloakService keycloakService) {
        this.usuarioRepository = usuarioRepository;
        this.keycloakService = keycloakService;
    }

    public Optional<List<User>> listarUsuarios() {
        return keycloakService.getUsers();
    }

    public boolean deletarUsuario(String userId) {
        Optional<HttpStatusCode> httpStatusCode = keycloakService.deleteUser(userId);
        return httpStatusCode.isPresent() && httpStatusCode.get().is2xxSuccessful();
    }
}
