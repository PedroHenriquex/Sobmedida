package com.sistemaGestao.demo.model;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Vendas")
@Table(name = "vendas")
@Getter
@Setter
// @Data

public class Venda extends Transacao{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
