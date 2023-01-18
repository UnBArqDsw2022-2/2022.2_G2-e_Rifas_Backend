package com.erifas.backend.service;

import com.erifas.backend.repository.jpa.core.AdministradorRepository;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {

    private final AdministradorRepository administradorRepository;

    public AdministradorService(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }
}
