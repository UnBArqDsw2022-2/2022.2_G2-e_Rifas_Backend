package com.erifas.backend.resource.controller;

import com.erifas.backend.persistence.model.SampleEntity;
import com.erifas.backend.service.SampleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sample")
public class SampleController {


    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping()
    public ResponseEntity<List<SampleEntity>> listarTodos() {
        return ResponseEntity.ok(sampleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SampleEntity> obterPorId(@PathVariable Long id){
        Optional<SampleEntity> sample = sampleService.findById(id);
        return sample.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<SampleEntity> cadastrarSampleEntity(@RequestBody SampleEntity e) {
        return ResponseEntity.ok(sampleService.save(e));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarPorId(@PathVariable Long id) {
        if (sampleService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}
