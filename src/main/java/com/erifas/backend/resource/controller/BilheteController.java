package com.erifas.backend.resource.controller;

import com.erifas.backend.persistence.model.Bilhete;
import com.erifas.backend.service.BilheteService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bilhete")
public class BilheteController {
    private final BilheteService bilheteService;

    public BilheteController(BilheteService bilheteService) {
        this.bilheteService = bilheteService;
    }

    @PostMapping()
    public ResponseEntity<Bilhete> cadastrarBilhete(@RequestBody Bilhete e) {
        return ResponseEntity.ok(bilheteService.save(e));
    }

    @PostMapping("/ganhadores")
    public ResponseEntity<List<Bilhete>> registrarGanhadores(@RequestBody List<Bilhete> bilhetes) {
        for (Bilhete bilhete : bilhetes) {
            bilhete.setSorteado(true);
        }

        return ResponseEntity.ok(bilheteService.saveAll(bilhetes));
    }
}
