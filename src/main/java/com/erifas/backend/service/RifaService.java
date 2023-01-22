package com.erifas.backend.service;

import com.erifas.backend.constants.StatusRifa;
import com.erifas.backend.persistence.model.Rifa;
import com.erifas.backend.repository.jpa.core.RifaRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RifaService {

    private final RifaRepository rifaRepository;

    public RifaService(RifaRepository rifaRepository) {
        this.rifaRepository = rifaRepository;
    }

    public boolean aprovarRifa(Long id) {
        Optional<Rifa> rifa = rifaRepository.findById(id);
        if (rifa.isPresent()) {
            rifa.get().setStatus(StatusRifa.ABERTA);
            rifaRepository.save(rifa.get());
            return true;
        }
        return false;
    }

    public boolean cancelarRifa(Long id) {
        Optional<Rifa> rifa = rifaRepository.findById(id);
        if (rifa.isPresent()) {
            rifa.get().setStatus(StatusRifa.CANCELADA);
            rifaRepository.save(rifa.get());
            return true;
        }
        return false;
    }

    public Optional<Rifa> findById(Long id) {
        return rifaRepository.findById(id);
    }

    public Optional<Integer> getMaxBilhetes(Long idRifa) {
        Optional<Rifa> rifa = rifaRepository.findById(idRifa);
        if (rifa.isPresent())
            return Optional.of(rifa.get().getMaximoBilhetes());
        return Optional.empty();
    }
}