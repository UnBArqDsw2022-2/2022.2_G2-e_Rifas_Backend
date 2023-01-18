package com.erifas.backend.resource.controller;

import com.erifas.backend.service.VendedorService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendedorController {

    private final VendedorService vendedorService;

    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }
}
