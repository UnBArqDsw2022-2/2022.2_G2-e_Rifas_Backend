package com.erifas.backend.resource.controller;

import com.erifas.backend.service.RifaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rifa")
public class RifaController {

    private final RifaService rifaService;

    public RifaController(RifaService rifaService) {
        this.rifaService = rifaService;
    }

    @PostMapping("/aprovar/{id}")
    public ResponseEntity<RifaService> aprovarRifa(@PathVariable Long id)
    {
       if(rifaService.aprovarRifa(id))
       {
           return ResponseEntity.ok(rifaService);
       }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/cancelar/{id}")
    public ResponseEntity<RifaService> cancelarRifa(@PathVariable Long id)
    {
        if(rifaService.cancelarRifa(id))
        {
            return ResponseEntity.ok(rifaService);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
