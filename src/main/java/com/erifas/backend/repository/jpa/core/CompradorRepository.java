package com.erifas.backend.repository.jpa.core;

import com.erifas.backend.persistence.model.Comprador;
import com.erifas.backend.repository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompradorRepository extends BaseJpaRepository<Comprador, Long> {
}
