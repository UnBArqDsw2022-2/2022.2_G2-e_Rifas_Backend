package com.erifas.backend.service;

import com.erifas.backend.repository.jpa.core.VendedorRepository;
import org.springframework.stereotype.Service;

@Service
public class VendedorService {

    private final VendedorRepository vendedorRepository;

    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }
}
