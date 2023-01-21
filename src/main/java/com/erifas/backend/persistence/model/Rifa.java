package com.erifas.backend.persistence.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rifa")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private StatusRifa status;

    @OneToMany(mappedBy = "rifa")
    private List<Bilhete> bilhetes;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
