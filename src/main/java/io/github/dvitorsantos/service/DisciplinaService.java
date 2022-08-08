package io.github.dvitorsantos.service;

import io.github.dvitorsantos.entity.Disciplina;
import io.github.dvitorsantos.repository.DisciplinaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    public Disciplina findById(Long id) {
        return disciplinaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "disciplina not found"));
    }

    public Disciplina save(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public void deleteById(Long id) {
        disciplinaRepository.deleteById(id);
    }

    public Disciplina update(Long id, Disciplina disciplina) {
        Disciplina disciplinaExistente = disciplinaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "disciplina not found"));
        disciplinaExistente.setDescricao(disciplina.getDescricao());
        return disciplinaRepository.save(disciplinaExistente);
    }
}
