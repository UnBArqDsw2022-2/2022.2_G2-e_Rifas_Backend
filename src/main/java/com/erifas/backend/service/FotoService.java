package com.erifas.backend.service;

import com.erifas.backend.repository.jpa.core.FotoRepository;
import org.springframework.stereotype.Service;

@Service
public class FotoService {

    private final FotoRepository fotoRepository;

    public FotoService(FotoRepository fotoRepository) {
        this.fotoRepository = fotoRepository;
    }
}
