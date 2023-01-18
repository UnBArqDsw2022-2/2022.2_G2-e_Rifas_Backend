package com.erifas.backend.repository.jpa.core;

import com.erifas.backend.persistence.model.Administrador;
import com.erifas.backend.repository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends BaseJpaRepository<Administrador, Long> {
}
