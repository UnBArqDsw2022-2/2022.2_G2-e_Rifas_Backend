package com.erifas.backend.resource.controller;

import com.erifas.backend.constants.StatusRifa;
import com.erifas.backend.service.RifaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rifa")
public class RifaController {

    private final RifaService rifaService;

    public RifaController(RifaService rifaService) {
        this.rifaService = rifaService;
    }


    @PutMapping("/aprovar/{id}")
    public ResponseEntity<RifaService> aprovarRifa(@PathVariable Long id)
    {
       if(rifaService.mudarStatusRifa(id, StatusRifa.ABERTA))
       {
           return ResponseEntity.ok(rifaService);
       }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/cancelar/{id}")
    public ResponseEntity<RifaService> cancelarRifa(@PathVariable Long id)
    {
        if(rifaService.mudarStatusRifa(id, StatusRifa.CANCELADA))
        {
            return ResponseEntity.ok(rifaService);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/fechar/{id}")
    public ResponseEntity<RifaService> fecharRifa(@PathVariable Long id)
    {
        if(rifaService.mudarStatusRifa(id, StatusRifa.FECHADA))
        {
            return ResponseEntity.ok(rifaService);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/analise/{id}")
    public ResponseEntity<RifaService> analisarRifa(@PathVariable Long id)
    {
        if(rifaService.mudarStatusRifa(id, StatusRifa.EM_ANALISE))
        {
            return ResponseEntity.ok(rifaService);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
