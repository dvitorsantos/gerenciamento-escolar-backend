package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.entity.Grade;
import io.github.dvitorsantos.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
public class GradeController {
    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping("/grades")
    public List<Grade> getGrades() {
        return gradeRepository.findAll();
    }

    @GetMapping("/grades/{id}")
    public Grade getGrade(@PathVariable(value = "id") Long id) {
        return gradeRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "grade not found"));
    }

    @PostMapping("/grades")
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeRepository.save(grade);
    }

    @DeleteMapping("/grades/{id}")
    public void deleteGrade(@PathVariable(value = "id") Long id) {
        gradeRepository.deleteById(id);
    }

    @PutMapping("/grades/{id}")
    public Grade updateGrade(@PathVariable(value = "id") Long id, @RequestBody Grade grade) {
        Grade gradeExistente = gradeRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "grade not found"));
        gradeExistente.setDescricao(grade.getDescricao());
        return gradeRepository.save(gradeExistente);
    }
}
