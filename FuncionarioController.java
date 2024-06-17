package com.sistemaGestao.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistemaGestao.demo.model.Funcionario;
import com.sistemaGestao.demo.service.FuncionarioService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    
    
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioService.getAllFuncionarios();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Funcionario> getFuncionarioByCpf(@PathVariable String cpf) {
        Optional<Funcionario> funcionario = funcionarioService.getFuncionarioByCpf(cpf);
        return funcionario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.createFuncionario(funcionario);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable String cpf, @RequestBody Funcionario funcionarioDetails) {
        Funcionario updatedFuncionario = funcionarioService.updateFuncionario(cpf, funcionarioDetails);
        return ResponseEntity.ok(updatedFuncionario);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable String cpf) {
        funcionarioService.deleteFuncionario(cpf);
        return ResponseEntity.noContent().build();
    }
}