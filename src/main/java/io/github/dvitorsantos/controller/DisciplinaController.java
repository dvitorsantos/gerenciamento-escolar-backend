package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.entity.Disciplina;
import io.github.dvitorsantos.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DisciplinaController {
    @Autowired
    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping("/disciplinas")
    public List<Disciplina> getDisciplinas() {
        return disciplinaService.findAll();
    }

    @GetMapping("/disciplinas/{id}")
    public Disciplina getDisciplina(@PathVariable(value = "id") Long id) {
        return disciplinaService.findById(id);
    }

    @PostMapping("/disciplinas")
    public Disciplina createDisciplina(@RequestBody Disciplina disciplina) {
        return disciplinaService.save(disciplina);
    }

    @DeleteMapping("/disciplinas/{id}")
    public void deleteDisciplina(@PathVariable(value = "id") Long id) {
        disciplinaService.deleteById(id);
    }

    @PutMapping("/disciplinas/{id}")
    public Disciplina updateDisciplina(@PathVariable(value = "id") Long id, @RequestBody Disciplina disciplina) {
        return disciplinaService.update(id, disciplina);
    }
}