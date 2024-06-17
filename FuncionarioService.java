package com.sistemaGestao.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.sistemaGestao.demo.repository.FuncionarioRepository;
import com.sistemaGestao.demo.model.Funcionario;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> getFuncionarioByCpf(String cpf) {
        return funcionarioRepository.findByCpf(cpf);
    }

    public Funcionario createFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario updateFuncionario(String cpf, Funcionario funcionarioDetails) {
        Funcionario funcionario = funcionarioRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        funcionario.setEmail(funcionarioDetails.getEmail());
        funcionario.setEndereco(funcionarioDetails.getEndereco());
        funcionario.setNome(funcionarioDetails.getNome());
        funcionario.setTelefone(funcionarioDetails.getTelefone());

        return funcionarioRepository.save(funcionario);
    }

    public void deleteFuncionario(String cpf) {
        Funcionario funcionario = funcionarioRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
        funcionarioRepository.delete(funcionario);
    }
}
