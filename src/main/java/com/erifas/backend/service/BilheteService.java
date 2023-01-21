package com.erifas.backend.service;

import com.erifas.backend.persistence.model.Bilhete;
import com.erifas.backend.repository.jpa.core.BilheteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BilheteService {
    private final BilheteRepository bilheteRepository;

    public BilheteService(BilheteRepository bilheteRepository) {
        this.bilheteRepository = bilheteRepository;
    }

    public Bilhete save(Bilhete e) {
        return bilheteRepository.save(e);
    }

    public List<Bilhete> saveAll(List<Bilhete> e) {
        return bilheteRepository.saveAll(e);
    }
}
