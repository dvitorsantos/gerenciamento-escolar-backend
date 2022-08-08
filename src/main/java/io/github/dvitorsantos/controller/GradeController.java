package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.entity.Grade;
import io.github.dvitorsantos.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/grades")
    public List<Grade> getGrades() {
        return gradeService.findAll();
    }

    @GetMapping("/grades/{id}")
    public Grade getGrade(@PathVariable(value = "id") Long id) {
        return gradeService.findById(id);
    }

    @PostMapping("/grades")
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.save(grade);
    }

    @DeleteMapping("/grades/{id}")
    public void deleteGrade(@PathVariable(value = "id") Long id) {
        gradeService.deleteById(id);
    }

    @PutMapping("/grades/{id}")
    public Grade updateGrade(@PathVariable(value = "id") Long id, @RequestBody Grade grade) {
        return gradeService.update(id, grade);
    }
}
