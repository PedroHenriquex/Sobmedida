package com.sistemaGestao.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistemaGestao.demo.model.Cliente;
import com.sistemaGestao.demo.service.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> getClienteByCpf(@PathVariable String cpf) {
        Optional<Cliente> cliente = clienteService.getClienteByCpf(cpf);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.createCliente(cliente);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable String cpf, @RequestBody Cliente clienteDetails) {
        Cliente updatedCliente = clienteService.updateCliente(cpf, clienteDetails);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deleteCliente(@PathVariable String cpf) {
        clienteService.deleteCliente(cpf);
        return ResponseEntity.noContent().build();
    }
}
