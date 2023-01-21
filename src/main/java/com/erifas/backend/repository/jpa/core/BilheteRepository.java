package com.erifas.backend.repository.jpa.core;

import com.erifas.backend.persistence.model.Bilhete;
import com.erifas.backend.repository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilheteRepository extends BaseJpaRepository<Bilhete, Long> {

}
