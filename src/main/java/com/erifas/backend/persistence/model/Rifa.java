package com.erifas.backend.persistence.model;

import com.erifas.backend.constants.StatusRifa;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rifa")
public class Rifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.ORDINAL)
    private StatusRifa status = StatusRifa.EM_ANALISE;
    private Integer maximoBilhetes;
    @Column(columnDefinition = "text")
    private String descricao;
    @OneToMany(mappedBy = "rifa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Bilhete> bilhetes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusRifa getStatus() {
        return status;
    }

    public void setStatus(StatusRifa status) {
        this.status = status;
    }

    public Integer getMaximoBilhetes() {
        return maximoBilhetes;
    }

    public void setMaximoBilhetes(Integer maximoBilhetes) {
        this.maximoBilhetes = maximoBilhetes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Bilhete> getBilhetes() {
        return bilhetes;
    }

    public void setBilhetes(List<Bilhete> bilhetes) {
        this.bilhetes = bilhetes;
    }
}
