package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.entity.Disciplina;
import io.github.dvitorsantos.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class DisciplinaController {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @GetMapping("/disciplinas")
    public List<Disciplina> getDisciplinas() {
        return disciplinaRepository.findAll();
    }

    @GetMapping("/disciplinas/{id}")
    public Disciplina getDisciplina(@PathVariable(value = "id") Long id) {
        return disciplinaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "disciplina not found"));
    }

    @PostMapping("/disciplinas")
    public Disciplina createDisciplina(@RequestBody Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @DeleteMapping("/disciplinas/{id}")
    public void deleteDisciplina(@PathVariable(value = "id") Long id) {
        disciplinaRepository.deleteById(id);
    }

    @PutMapping("/disciplinas/{id}")
    public Disciplina updateDisciplina(@PathVariable(value = "id") Long id, @RequestBody Disciplina disciplina) {
        Disciplina disciplinaExistente = disciplinaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "disciplina not found"));
        disciplinaExistente.setDescricao(disciplina.getDescricao());
        return disciplinaRepository.save(disciplinaExistente);
    }
}