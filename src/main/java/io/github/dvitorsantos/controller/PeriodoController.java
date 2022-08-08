package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.entity.Periodo;
import io.github.dvitorsantos.service.PeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeriodoController {
    @Autowired
    private final PeriodoService periodoService;

    public PeriodoController(PeriodoService periodoService) {
        this.periodoService = periodoService;
    }

    @GetMapping("/periodos")
    public List<Periodo> getPeriodos() {
        return periodoService.findAll();
    }

    @GetMapping("/periodos/{id}")
    public Periodo getPeriodo(@PathVariable(value = "id") Long id) {
        return periodoService.findById(id);
    }

    @PostMapping("/periodos")
    public Periodo createPeriodo(@RequestBody Periodo periodo) {
        return periodoService.save(periodo);
    }

    @DeleteMapping("/periodos/{id}")
    public void deletePeriodo(@PathVariable(value = "id") Long id) {
        periodoService.deleteById(id);
    }

    @PutMapping("/periodos/{id}")
    public Periodo updatePeriodo(@PathVariable(value = "id") Long id, @RequestBody Periodo periodo) {
        return periodoService.update(id, periodo);
    }
}
