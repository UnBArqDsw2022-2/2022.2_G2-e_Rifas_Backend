package com.erifas.backend.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "comprador")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comprador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "comprador")
    private List<Bilhete> bilhetes;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
