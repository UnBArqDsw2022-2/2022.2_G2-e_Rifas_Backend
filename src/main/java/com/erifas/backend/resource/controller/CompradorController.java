package com.erifas.backend.resource.controller;

import com.erifas.backend.service.CompradorService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompradorController {

    private final CompradorService compradorService;

    public CompradorController(CompradorService compradorService) {
        this.compradorService = compradorService;
    }
}
