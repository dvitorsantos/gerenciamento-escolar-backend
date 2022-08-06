package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.entity.Serie;
import io.github.dvitorsantos.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class SerieController {
    @Autowired
    private SerieRepository serieRepository;

    @GetMapping("/series")
    public List<Serie> getSeries() {
        return serieRepository.findAll();
    }

    @GetMapping("/series/{id}")
    public Serie getSerie(@PathVariable(value = "id") Long id) {
        return serieRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "serie not found"));
    }

    @PostMapping("/series")
    public Serie createSerie(@RequestBody Serie serie) {
        return serieRepository.save(serie);
    }

    @DeleteMapping("/series/{id}")
    public void deleteSerie(@PathVariable(value = "id") Long id) {
        serieRepository.deleteById(id);
    }

    @PutMapping("/series/{id}")
    public Serie updateSerie(@PathVariable(value = "id") Long id, @RequestBody Serie serie) {
        Serie serieExistente = serieRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "serie not found"));
        serieExistente.setDescricao(serie.getDescricao());
        return serieRepository.save(serieExistente);
    }
}
