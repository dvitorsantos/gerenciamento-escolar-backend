package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.github.dvitorsantos.entity.Aluno;
import io.github.dvitorsantos.repository.AlunoRepository;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/alunos")
    @ResponseBody
    public List<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }

    @GetMapping("/alunos/{id}")
    @ResponseBody
    public Aluno getAluno(@PathVariable(value = "id") Long id) {
        return alunoService.findById(id);
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


    @GetMapping("/alunos/{id}/matriculas")
    @ResponseBody
    public Aluno getAlunoFetchMatriculas(@PathVariable(value = "id") Long id) {
        return alunoRepository
                .findByIdFetchMatriculas(id);
    }
}

