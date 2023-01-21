package com.erifas.backend.persistence.model;

import com.erifas.backend.constants.StatusRifa;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "rifa")
@Data
public class Rifa {
    @Id
    private Long id;
    private StatusRifa status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setStatus(StatusRifa status) { this.status = status; }

    public Enum<StatusRifa> getStatus() { return this.status; }
}