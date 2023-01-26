package com.erifas.backend.service;

import com.erifas.backend.persistence.model.Bilhete;
import com.erifas.backend.persistence.model.Comprador;
import com.erifas.backend.persistence.model.Rifa;
import com.erifas.backend.repository.jpa.core.BilheteRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BilheteService {
    private final BilheteRepository bilheteRepository;
    private final RifaService rifaService;
    private final CompradorService compradorService;


    public BilheteService(BilheteRepository bilheteRepository, RifaService rifaService, CompradorService compradorService) {
        this.bilheteRepository = bilheteRepository;
        this.rifaService = rifaService;
        this.compradorService = compradorService;
    }

    public Optional<Bilhete> save(Bilhete e, Long idRifa) {
        Optional<Comprador> compradorByUserId = compradorService.getCompradorByUserId(e.getComprador().getUsuario().getId());
        if (compradorByUserId.isPresent()) {
            Optional<Rifa> rifaById = rifaService.findById(idRifa);
            if (rifaById.isPresent()) {
                e.setComprador(compradorByUserId.get());
                e.setRifa(rifaById.get());
                return Optional.of(bilheteRepository.save(e));
            }
        }
        return Optional.empty();
    }

    public List<Bilhete> saveAll(List<Bilhete> e) {
        return bilheteRepository.saveAll(e);
    }

    public Optional<Integer> getCountBilhetes(Long idRifa) {
        return rifaService.getCountBilhetes(idRifa);
    }

    public Boolean verificaCountMaximoBilhetes(Long idRifa) {
        Optional<Integer> maximoBilhetes = rifaService.getMaxBilhetes(idRifa);
        if (maximoBilhetes.isPresent()) {
            return rifaService.getCountBilhetes(idRifa).get() + 1 <= maximoBilhetes.get();
        }
        return false;
    }
}
