package com.erifas.backend.resource.controller;

import com.erifas.backend.service.RifaService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RifaController {

    private final RifaService rifaService;

    public RifaController(RifaService rifaService) {
        this.rifaService = rifaService;
    }
}
