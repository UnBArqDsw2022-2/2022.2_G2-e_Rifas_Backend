package com.erifas.backend.repository;

import com.erifas.backend.persistence.model.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<SampleEntity, Long>, JpaSpecificationExecutor<SampleEntity> {
}
