package com.erifas.backend.repository.jpa.core;

import com.erifas.backend.persistence.model.Comprador;
import com.erifas.backend.persistence.model.Usuario;
import com.erifas.backend.repository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompradorRepository extends BaseJpaRepository<Comprador, Long> {
    Comprador findCompradorByUsuario(Usuario usuario);
}
