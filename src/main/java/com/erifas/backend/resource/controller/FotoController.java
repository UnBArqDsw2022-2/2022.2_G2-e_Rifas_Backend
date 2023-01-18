package com.erifas.backend.resource.controller;

import com.erifas.backend.service.FotoService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FotoController {

    private final FotoService fotoService;

    public FotoController(FotoService fotoService) {
        this.fotoService = fotoService;
    }
}
