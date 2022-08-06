package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.entity.Turma;
import io.github.dvitorsantos.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TurmaController {
    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping("/turmas")
    public List<Turma> getTurmas() {
        return turmaRepository.findAll();
    }

    @GetMapping("/turmas/{id}")
    public Turma getTurma(@PathVariable(value = "id") Long id) {
        return turmaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "turma not found"));
    }

    @PostMapping("/turmas")
    public Turma createTurma(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }

    @DeleteMapping("/turmas/{id}")
    public void deleteTurma(@PathVariable(value = "id") Long id) {
        turmaRepository.deleteById(id);
    }

    @PutMapping("/turmas/{id}")
    public Turma updateTurma(@PathVariable(value = "id") Long id, @RequestBody Turma turma) {
        Turma turmaExistente = turmaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "turma not found"));
        turmaExistente.setDescricao(turma.getDescricao());
        return turmaRepository.save(turmaExistente);
    }
}
