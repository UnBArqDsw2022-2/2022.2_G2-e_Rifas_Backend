package com.erifas.backend.persistence.model;

import jakarta.persistence.*;

@Entity
@Table(name = "foto")
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "rifa_id", nullable = false)
    private Rifa rifa;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
