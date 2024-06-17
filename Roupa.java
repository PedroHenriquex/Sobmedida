package com.sistemaGestao.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity(name = "Roupa")
@Table(name = "roupa")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter

public class Roupa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(nullable = true)
    private String marca;

    @Column(nullable = true)
    private String descricao;

    @Column(nullable = false)
    private String tamanho;

    @Column(nullable = true)
    private String cor;

    @Column(nullable = true)
    private double preco;

    @Column(nullable = true)
    private double precoDiaria;

    @Column(nullable = false)
    private boolean disponivel;

}
