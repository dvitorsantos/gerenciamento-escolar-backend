package io.github.dvitorsantos.service;

import io.github.dvitorsantos.entity.Aluno;
import io.github.dvitorsantos.repository.AlunoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno findById(Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "aluno not found"));
    }
}
