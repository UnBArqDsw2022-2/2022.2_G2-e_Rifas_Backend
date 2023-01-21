package com.erifas.backend.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bilhete")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bilhete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numero;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comprador comprador;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rifa rifa;

    @Column(columnDefinition = "boolean default false")
    private Boolean sorteado;

}
