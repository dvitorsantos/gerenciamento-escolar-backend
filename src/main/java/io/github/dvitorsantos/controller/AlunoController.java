package io.github.dvitorsantos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.github.dvitorsantos.entity.Aluno;
import io.github.dvitorsantos.repository.AlunoRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/alunos")
    @ResponseBody
    public List<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }

    @GetMapping("/alunos/{id}")
    @ResponseBody
    public Aluno getAluno(@PathVariable(value = "id") Long id) {
        return alunoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "aluno not found"));
    }

    @PostMapping("/alunos")
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @DeleteMapping("/alunos/{id}")
    public void deleteAluno(@PathVariable(value = "id") Long id) {
        alunoRepository.deleteById(id);
    }

    @PutMapping("/alunos/{id}")
    public Aluno updateAluno(@PathVariable(value = "id") Long id, @RequestBody Aluno aluno) {
        Aluno alunoExistente = alunoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "aluno not found"));
        alunoExistente.setNome(aluno.getNome());
        return alunoRepository.save(alunoExistente);
    }
}
