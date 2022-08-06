package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.entity.Diario;
import io.github.dvitorsantos.repository.DiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class DiarioController {

    @Autowired
    private DiarioRepository diarioRepository;

    @GetMapping("/diarios")
    public List<Diario> getDiarios() {
        return diarioRepository.findAll();
    }

    @GetMapping("/diarios/{id}")
    public Diario getDiario(@PathVariable(value = "id") Long id) {
        return diarioRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "diario not found"));
    }

    @PostMapping("/diarios")
    public Diario createDiario(@RequestBody Diario diario) {
        return diarioRepository.save(diario);
    }

    @DeleteMapping("/diarios/{id}")
    public void deleteDiario(@PathVariable(value = "id") Long id) {
        diarioRepository.deleteById(id);
    }

    @PutMapping("/diarios/{id}")
    public Diario updateDiario(@PathVariable(value = "id") Long id, @RequestBody Diario diario) {
        Diario diarioExistente = diarioRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "diario not found"));
        diarioExistente.setDescricao(diario.getDescricao());
        return diarioRepository.save(diarioExistente);
    }
}
