package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.dto.turma.TurmaFetchMatriculaResponseDto;
import io.github.dvitorsantos.dto.turma.TurmaResponseDto;
import io.github.dvitorsantos.entity.Turma;
import io.github.dvitorsantos.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TurmaController {
    @Autowired
    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping("/turmas")
    public List<TurmaResponseDto> getTurmas() {
        List<Turma> turmas = turmaService.findAll();
        ArrayList<TurmaResponseDto> turmaResponseDtos = new ArrayList<>();

        for (Turma turma : turmas) {
            turmaResponseDtos.add(TurmaResponseDto.fromEntity(turma));
        }

        return turmaResponseDtos;
    }

    @GetMapping("/turmas/{id}")
    public TurmaResponseDto getTurma(@PathVariable(value = "id") Long id) {
        Turma turma = turmaService.findById(id);
        return TurmaResponseDto.fromEntity(turma);
    }

    @GetMapping("/turmas/{id}/matriculas")
    public TurmaFetchMatriculaResponseDto getTurmaFetchMatriculas(@PathVariable(value = "id") Long id) {
        Turma turma = turmaService.findById(id);
        return TurmaFetchMatriculaResponseDto.fromEntity(turma);
    }

    @PostMapping("/turmas")
    public Turma createTurma(@RequestBody Turma turma) {
        return turmaService.save(turma);
    }

    @DeleteMapping("/turmas/{id}")
    public void deleteTurma(@PathVariable(value = "id") Long id) {
        turmaService.deleteById(id);
    }

    @PutMapping("/turmas/{id}")
    public Turma updateTurma(@PathVariable(value = "id") Long id, @RequestBody Turma turma) {
        return turmaService.update(id, turma);
    }
}
