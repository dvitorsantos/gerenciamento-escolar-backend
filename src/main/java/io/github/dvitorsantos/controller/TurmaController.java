package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.entity.Turma;
import io.github.dvitorsantos.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TurmaController {
    @Autowired
    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping("/turmas")
    public List<Turma> getTurmas() {
        return turmaService.findAll();
    }

    @GetMapping("/turmas/{id}")
    public Turma getTurma(@PathVariable(value = "id") Long id) {
        return turmaService.findById(id);
    }

    @PostMapping("/turmas")
    public Turma createTurma(@RequestBody Turma turma) {
        return turmaService.save(turma);
    }

    @DeleteMapping("/turmas/{id}")
    public void deleteTurma(@PathVariable(value = "id") Long id) {
        turmaService.deleteById(id);
    }

    @PutMapping("/turmas/{id}")
    public Turma updateTurma(@PathVariable(value = "id") Long id, @RequestBody Turma turma) {
        return turmaService.update(id, turma);
    }
}
