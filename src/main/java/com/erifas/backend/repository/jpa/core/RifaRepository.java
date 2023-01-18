package com.erifas.backend.repository.jpa.core;

import com.erifas.backend.persistence.model.Rifa;
import com.erifas.backend.repository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RifaRepository extends BaseJpaRepository<Rifa, Long> {
}
