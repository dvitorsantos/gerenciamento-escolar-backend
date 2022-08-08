package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.entity.Matricula;
import io.github.dvitorsantos.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatriculaController {
    @Autowired
    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping("/matriculas")
    public List<Matricula> getMatriculas() {
        return matriculaService.findAll();
    }

    @GetMapping("/matriculas/{id}")
    public Matricula getMatricula(@PathVariable(value = "id") Long id) {
        return matriculaService.findById(id);
    }

    @PostMapping("/matriculas")
    public Matricula create(@RequestBody Matricula matricula) {
        return matriculaService.create(matricula);
    }

    @DeleteMapping("/matriculas/{id}")
    public void deleteMatricula(@PathVariable(value = "id") Long id) {
        matriculaService.deleteById(id);
    }
}
