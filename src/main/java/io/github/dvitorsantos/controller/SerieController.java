package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.entity.Serie;
import io.github.dvitorsantos.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SerieController {
    @Autowired
    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping("/series")
    public List<Serie> getSeries() {
        return serieService.findAll();
    }

    @GetMapping("/series/{id}")
    public Serie getSerie(@PathVariable(value = "id") Long id) {
        return serieService.findById(id);
    }

    @PostMapping("/series")
    public Serie createSerie(@RequestBody Serie serie) {
        return serieService.save(serie);
    }

    @DeleteMapping("/series/{id}")
    public void deleteSerie(@PathVariable(value = "id") Long id) {
        serieService.deleteById(id);
    }

    @PutMapping("/series/{id}")
    public Serie updateSerie(@PathVariable(value = "id") Long id, @RequestBody Serie serie) {
        return serieService.update(id, serie);
    }
}
