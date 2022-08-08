package io.github.dvitorsantos.service;

import io.github.dvitorsantos.entity.Aluno;
import io.github.dvitorsantos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id) {
        return alunoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "aluno not found"));
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }

    public Aluno update(Long id, Aluno aluno) {
        Aluno alunoExistente = alunoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "aluno not found"));
        alunoExistente.setNome(aluno.getNome());
        return alunoRepository.save(alunoExistente);
    }

    public Aluno findByIdFetchMatriculas(Long id) {
        return alunoRepository
                .findByIdFetchMatriculas(id);
    }
}
