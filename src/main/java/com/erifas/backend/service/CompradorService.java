package com.erifas.backend.service;

import com.erifas.backend.repository.jpa.core.CompradorRepository;
import org.springframework.stereotype.Service;

@Service

public class CompradorService {

    private final CompradorRepository compradorRepository;

    public CompradorService(CompradorRepository compradorRepository) {
        this.compradorRepository = compradorRepository;
    }
}
