package com.erifas.backend.repository.jpa.core;

import com.erifas.backend.persistence.model.Produto;
import com.erifas.backend.repository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends BaseJpaRepository<Produto, Long> {
}
