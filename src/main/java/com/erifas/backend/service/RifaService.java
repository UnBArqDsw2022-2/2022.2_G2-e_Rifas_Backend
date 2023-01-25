package com.erifas.backend.service;

import com.erifas.backend.constants.StatusRifa;
import com.erifas.backend.persistence.model.Rifa;
import com.erifas.backend.repository.jpa.core.RifaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RifaService {

    private final RifaRepository rifaRepository;

    public RifaService(RifaRepository rifaRepository) {
        this.rifaRepository = rifaRepository;
    }

    public boolean mudarStatusRifa (Long id, StatusRifa status)
    {
        Optional<Rifa> rifa = rifaRepository.findById(id);
        if(rifa.isPresent())
        {
            switch (status) {
                case ABERTA -> rifa.get().setStatus(StatusRifa.ABERTA);
                case FECHADA -> rifa.get().setStatus(StatusRifa.FECHADA);
                case CANCELADA -> rifa.get().setStatus(StatusRifa.CANCELADA);
            }
            rifaRepository.save(rifa.get());
            return true;
        }
        return false;
    }
}
