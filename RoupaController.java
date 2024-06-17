package com.sistemaGestao.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.sistemaGestao.demo.service.RoupaService;
import com.sistemaGestao.demo.model.Roupa;

@RestController
@RequestMapping("/roupas")
public class RoupaController {
    
    @Autowired
    private RoupaService roupaService;

    @GetMapping
    public List<Roupa> getAllRoupas() {
        return roupaService.getAllRoupas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Roupa> getRoupaById(@PathVariable Long id) {
        Optional<Roupa> roupa = roupaService.getRoupaById(id);
        return roupa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Roupa createRoupa(@RequestBody Roupa roupa) {
        return roupaService.createRoupa(roupa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Roupa> updateRoupa(@PathVariable Long id, @RequestBody Roupa roupaDetails) {
        Roupa updatedRoupa = roupaService.updateRoupa(id, roupaDetails);
        return ResponseEntity.ok(updatedRoupa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoupa(@PathVariable Long id) {
        roupaService.deleteRoupa(id);
        return ResponseEntity.noContent().build();
    }
}
