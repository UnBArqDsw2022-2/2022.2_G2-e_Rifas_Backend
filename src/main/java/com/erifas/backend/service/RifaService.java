package com.erifas.backend.service;

import com.erifas.backend.repository.jpa.core.RifaRepository;
import org.springframework.stereotype.Service;

@Service
public class RifaService {

    private final RifaRepository rifaRepository;

    public RifaService(RifaRepository rifaRepository) {
        this.rifaRepository = rifaRepository;
    }
}
