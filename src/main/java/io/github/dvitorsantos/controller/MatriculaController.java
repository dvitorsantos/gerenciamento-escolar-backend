package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.entity.Aluno;
import io.github.dvitorsantos.entity.Matricula;
import io.github.dvitorsantos.entity.Turma;
import io.github.dvitorsantos.repository.AlunoRepository;
import io.github.dvitorsantos.repository.MatriculaRepository;
import io.github.dvitorsantos.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class MatriculaController {
    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    TurmaRepository turmaRepository;

    @RequestMapping("/matriculas")
    public List<Matricula> getMatriculas() {
        return matriculaRepository.findAll();
    }

    @RequestMapping("/matriculas/{id}")
    public Matricula getMatricula(@PathVariable(value = "id") Long id) {
        return matriculaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "matricula not found"));
    }

    @PostMapping("/matriculas")
    public Matricula createMatricula(@RequestBody Matricula matricula) {
        Aluno aluno = alunoRepository
                .findById(matricula.getAluno().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "aluno not found"));

        Turma turma = turmaRepository
                .findById(matricula.getTurma().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "turma not found"));

        return matriculaRepository.save(new Matricula(aluno, turma));
    }

    @DeleteMapping("/matriculas/{id}")
    public void deleteMatricula(@PathVariable(value = "id") Long id) {
        matriculaRepository.deleteById(id);
    }
}
