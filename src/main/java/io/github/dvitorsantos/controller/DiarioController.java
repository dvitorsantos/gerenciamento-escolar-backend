package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.entity.Diario;
import io.github.dvitorsantos.service.DiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiarioController {

    @Autowired
    private final DiarioService diarioService;

    public DiarioController(DiarioService diarioService) {
        this.diarioService = diarioService;
    }

    @GetMapping("/diarios")
    public List<Diario> getDiarios() {
        return diarioService.findAll();
    }

    @GetMapping("/diarios/{id}")
    public Diario getDiario(@PathVariable(value = "id") Long id) {
        return diarioService.findById(id);
    }

    @PostMapping("/diarios")
    public Diario createDiario(@RequestBody Diario diario) {
        return diarioService.save(diario);
    }

    @DeleteMapping("/diarios/{id}")
    public void deleteDiario(@PathVariable(value = "id") Long id) {
        diarioService.deleteById(id);
    }

    @PutMapping("/diarios/{id}")
    public Diario updateDiario(@PathVariable(value = "id") Long id, @RequestBody Diario diario) {
        return diarioService.update(id, diario);
    }
}
