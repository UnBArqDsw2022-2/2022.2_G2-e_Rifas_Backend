package com.erifas.backend.repository.jpa.core;

import java.util.List;

import com.erifas.backend.constants.StatusRifa;
import com.erifas.backend.persistence.model.Rifa;
import com.erifas.backend.repository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RifaRepository extends BaseJpaRepository<Rifa, Long> {

    List<Rifa> findByStatus(StatusRifa statusRifa);
}
