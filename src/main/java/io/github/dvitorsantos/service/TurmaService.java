package io.github.dvitorsantos.service;

import io.github.dvitorsantos.entity.Turma;
import io.github.dvitorsantos.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TurmaService {
    @Autowired
    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    public Turma findById(Long id) {
        return turmaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "turma not found"));
    }

    public Turma create(Turma turma) {
        return turmaRepository.save(turma);
    }

    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    public void deleteById(Long id) {
        turmaRepository.deleteById(id);
    }

    public void delete(Turma turma) {
        turmaRepository.delete(turma);
    }

    public Turma update(Long id, Turma turma) {
        Turma turmaExistente = turmaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "turma not found"));
        turmaExistente.setDescricao(turma.getDescricao());
        return turmaRepository.save(turmaExistente);
    }
}
