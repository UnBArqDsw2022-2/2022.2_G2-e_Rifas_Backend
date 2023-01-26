package com.erifas.backend.resource.controller;

import com.erifas.backend.persistence.model.Comprador;
import com.erifas.backend.service.CompradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comprador")
public class CompradorController {

    private final CompradorService compradorService;

    public CompradorController(CompradorService compradorService) {
        this.compradorService = compradorService;
    }

    @PostMapping
    public ResponseEntity<Comprador> adicionarComprador(@RequestBody Comprador comprador) {
        return compradorService.save(comprador).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
