package com.erifas.backend.repository.jpa.core;

import com.erifas.backend.persistence.model.Usuario;
import com.erifas.backend.repository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends BaseJpaRepository<Usuario, Long> {
}
