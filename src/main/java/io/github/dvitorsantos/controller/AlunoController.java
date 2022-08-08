package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.github.dvitorsantos.entity.Aluno;

import java.util.List;

@RestController
public class AlunoController {

    @Autowired
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/alunos")
    @ResponseBody
    public List<Aluno> getAlunos() {
        return alunoService.findAll();
    }

    @GetMapping("/alunos/{id}")
    @ResponseBody
    public Aluno getAluno(@PathVariable(value = "id") Long id) {
        return alunoService.findById(id);
    }

    @PostMapping("/alunos")
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    @DeleteMapping("/alunos/{id}")
    public void deleteAluno(@PathVariable(value = "id") Long id) {
        alunoService.deleteById(id);
    }

    @PutMapping("/alunos/{id}")
    public Aluno updateAluno(@PathVariable(value = "id") Long id, @RequestBody Aluno aluno) {
        return alunoService.update(id, aluno);
    }

    @GetMapping("/alunos/{id}/matriculas")
    @ResponseBody
    public Aluno getAlunoFetchMatriculas(@PathVariable(value = "id") Long id) {
        return alunoService
                .findByIdFetchMatriculas(id);
    }
}

