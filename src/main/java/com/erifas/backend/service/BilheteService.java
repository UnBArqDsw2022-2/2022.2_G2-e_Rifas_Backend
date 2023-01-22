package com.erifas.backend.service;

import com.erifas.backend.persistence.model.Bilhete;
import com.erifas.backend.persistence.model.Rifa;
import com.erifas.backend.repository.jpa.core.BilheteRepository;
import com.erifas.backend.repository.jpa.core.RifaRepository;
import com.erifas.backend.resource.controller.RifaController;

import org.springframework.stereotype.Service;
import java.util.List;

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

    // Não testado, talvez retorne um json
    public Optional<Integer> getCountBilhetes(Long idRifa) {
        Optional<Integer> quantBilhetes = rifaService.getMaxBilhetes(idRifa); // contar bilhetes com id da rifa atual
        return quantBilhetes;
    }

    public Boolean verificaCountMaximoBilhetes(Long idRifa) {
        // como usar o rifa service dentro do bilhete service
        Optional<Integer> maximoBilhetes = getCountBilhetes(idRifa);
        if (maximoBilhetes.isPresent()) {
            if (maximoBilhetes.get() + 1 <= maximoBilhetes.get()) {
                return true;
            }
        }
        return false;
    }
}
