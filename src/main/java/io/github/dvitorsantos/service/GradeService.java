package io.github.dvitorsantos.service;

import io.github.dvitorsantos.entity.Grade;
import io.github.dvitorsantos.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    public Grade findById(Long id) {
        return gradeRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "grade not found"));
    }

    public Grade save(Grade grade) {
        return gradeRepository.save(grade);
    }

    public void deleteById(Long id) {
        gradeRepository.deleteById(id);
    }

    public Grade update(Long id, Grade grade) {
        Grade gradeExistente = gradeRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "grade not found"));
        gradeExistente.setDescricao(grade.getDescricao());
        return gradeRepository.save(gradeExistente);
    }
}
