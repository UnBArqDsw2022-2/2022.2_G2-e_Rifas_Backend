package com.erifas.backend.repository.jpa.core;

import com.erifas.backend.persistence.model.Foto;
import com.erifas.backend.repository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends BaseJpaRepository<Foto, Long> {
}
