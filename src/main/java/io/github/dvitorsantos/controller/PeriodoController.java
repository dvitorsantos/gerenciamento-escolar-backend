package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.entity.Periodo;
import io.github.dvitorsantos.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PeriodoController {
    @Autowired
    private PeriodoRepository periodoRepository;

    @GetMapping("/periodos")
    public List<Periodo> getPeriodos() {
        return periodoRepository.findAll();
    }

    @GetMapping("/periodos/{id}")
    public Periodo getPeriodo(@PathVariable(value = "id") Long id) {
        return periodoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "periodo not found"));
    }

    @PostMapping("/periodos")
    public Periodo createPeriodo(@RequestBody Periodo periodo) {
        return periodoRepository.save(periodo);
    }

    @DeleteMapping("/periodos/{id}")
    public void deletePeriodo(@PathVariable(value = "id") Long id) {
        periodoRepository.deleteById(id);
    }

    @PutMapping("/periodos/{id}")
    public Periodo updatePeriodo(@PathVariable(value = "id") Long id, @RequestBody Periodo periodo) {
        Periodo periodoExistente = periodoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "periodo not found"));
        periodoExistente.setDescricao(periodo.getDescricao());
        return periodoRepository.save(periodoExistente);
    }
}
