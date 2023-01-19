package com.erifas.backend.service;

import com.erifas.backend.persistence.model.SampleEntity;
import com.erifas.backend.repository.SampleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SampleService {

    private final SampleRepository sampleRepository;

    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public SampleEntity save(SampleEntity e) {
        return sampleRepository.save(e);
    }

    public List<SampleEntity> findAll() {
        
        return sampleRepository.findAll();
    }

    public Optional<SampleEntity> findById(Long id) {
        return sampleRepository.findById(id);
    }

    public boolean deleteById(Long id) {
        if (sampleRepository.existsById(id)) {
            sampleRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
