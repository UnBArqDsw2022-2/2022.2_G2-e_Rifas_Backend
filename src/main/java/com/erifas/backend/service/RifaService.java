package com.erifas.backend.service;

import com.erifas.backend.constants.StatusRifa;
import com.erifas.backend.persistence.model.Rifa;
import com.erifas.backend.repository.jpa.core.RifaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RifaService {

    private final RifaRepository rifaRepository;
    Logger logger = LoggerFactory.getLogger(RifaService.class);

    public RifaService(RifaRepository rifaRepository) {
        this.rifaRepository = rifaRepository;
    }

    public Rifa criarRifa(Rifa rifa) {
        return rifaRepository.save(rifa);
    }

    public boolean mudarStatusRifa(Long id, StatusRifa status) {
        Optional<Rifa> rifa = rifaRepository.findById(id);
        if (rifa.isPresent()) {
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

    public ResponseEntity<List<Rifa>> getRifasPeloStatus(StatusRifa statusRifa) {
        try {
            List<Rifa> rifas = rifaRepository.findAll().stream().filter(r -> r.getStatus() == statusRifa).toList();
            if (!rifas.isEmpty()) {
                logger.info("Rifas encontradas com status {}: {}", statusRifa, rifas);
                return new ResponseEntity<>(rifas, HttpStatus.OK);
            } else {
                logger.warn("Nenhuma rifa encontrada com status {}", statusRifa);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("Erro ao encontrar rifas com status {}", statusRifa, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public Optional<Integer> getMaxBilhetes(Long idRifa) {
        Optional<Rifa> rifaById = rifaRepository.findById(idRifa);
        return rifaById.map(Rifa::getMaximoBilhetes);
    }

    public Optional<Integer> getCountBilhetes(Long idRifa) {
        Optional<Rifa> rifaById = rifaRepository.findById(idRifa);
        return rifaById.map(rifa -> (rifa.getBilhetes() != null) ? rifa.getBilhetes().size() : 0);
    }

    public Optional<Rifa> findById(Long idRifa) {
        return rifaRepository.findById(idRifa);
    }

    public List<Rifa> getRifasTotal() {
        return new ArrayList<>(rifaRepository.findAll());
    }
}
