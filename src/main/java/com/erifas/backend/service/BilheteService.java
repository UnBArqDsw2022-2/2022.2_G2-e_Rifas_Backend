package com.erifas.backend.service;

import com.erifas.backend.persistence.model.Bilhete;
import com.erifas.backend.persistence.model.Rifa;
import com.erifas.backend.repository.jpa.core.BilheteRepository;
import com.erifas.backend.repository.jpa.core.RifaRepository;
import com.erifas.backend.resource.controller.RifaController;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BilheteService {
    private final BilheteRepository bilheteRepository;
    private final RifaService rifaService;

    public BilheteService(BilheteRepository bilheteRepository, RifaService rifaService) {
        this.bilheteRepository = bilheteRepository;
        this.rifaService = rifaService;
    }

    public Bilhete save(Bilhete e) {
        return bilheteRepository.save(e);
    }

    public List<Bilhete> saveAll(List<Bilhete> e) {
        return bilheteRepository.saveAll(e);
    }

    public Optional<Integer> getCountBilhetes(Long idRifa) {
        return rifaService.getMaxBilhetes(idRifa);
    }

    public Boolean verificaCountMaximoBilhetes(Long idRifa) {
        Optional<Integer> maximoBilhetes = getCountBilhetes(idRifa);
        return maximoBilhetes.filter(integer -> integer + 1 <= integer).isPresent();
    }
}
