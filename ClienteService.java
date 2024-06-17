package com.sistemaGestao.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.sistemaGestao.demo.model.Cliente;
import com.sistemaGestao.demo.repository.ClienteRepository;

// import io.micrometer.core.instrument.Meter.Id;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getClienteByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(String cpf, Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.setEmail(clienteDetails.getEmail());
        cliente.setEndereco(clienteDetails.getEndereco());
        cliente.setNome(clienteDetails.getNome());
        cliente.setTelefone(clienteDetails.getTelefone());

        return clienteRepository.save(cliente);
    }

    public void deleteCliente(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        clienteRepository.delete(cliente);
    }
}
