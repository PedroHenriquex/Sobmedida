package com.sistemaGestao.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.sistemaGestao.demo.model.Roupa;
import com.sistemaGestao.demo.repository.RoupaRepository;

@Service
public class RoupaService {

    @Autowired
    private RoupaRepository roupaRepository;

    public List<Roupa> getAllRoupas() {
        return roupaRepository.findAll();
    }

    public Optional<Roupa> getRoupaById(Long id) {
        return roupaRepository.findById(id);
    }

    public Roupa createRoupa(Roupa roupa) {
        return roupaRepository.save(roupa);
    }

    public Roupa updateRoupa(Long id, Roupa roupaDetails) {
        Roupa roupa = roupaRepository.findById(id).orElseThrow(() -> new RuntimeException("Roupa não encontrada"));

        roupa.setTamanho(roupaDetails.getTamanho());
        roupa.setCor(roupaDetails.getCor());
        roupa.setPreco(roupaDetails.getPreco());

        return roupaRepository.save(roupa);
    }

    public void deleteRoupa(Long id) {
        Roupa roupa = roupaRepository.findById(id).orElseThrow(() -> new RuntimeException("Roupa não encontrada"));
        roupaRepository.delete(roupa);
    }
}
