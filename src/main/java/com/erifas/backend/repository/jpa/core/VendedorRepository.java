package com.erifas.backend.repository.jpa.core;

import com.erifas.backend.persistence.model.Vendedor;
import com.erifas.backend.repository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends BaseJpaRepository<Vendedor, Long> {
}
