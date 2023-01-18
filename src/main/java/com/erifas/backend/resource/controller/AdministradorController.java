package com.erifas.backend.resource.controller;

import com.erifas.backend.service.AdministradorService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministradorController {

    private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }
}
