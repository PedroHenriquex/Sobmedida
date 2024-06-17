package com.sistemaGestao.demo.repository;

import com.sistemaGestao.demo.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByCpf(String cpf);    //metodo de consulta pelo CPF
    Optional<Funcionario> findByNome(String nome);    //metodo de consulta pelo nome
}