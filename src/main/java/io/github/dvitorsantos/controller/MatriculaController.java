package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.dto.matricula.MatriculaDto;
import io.github.dvitorsantos.dto.matricula.MatriculaResponseDto;
import io.github.dvitorsantos.entity.Matricula;
import io.github.dvitorsantos.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MatriculaController {
    @Autowired
    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping("/matriculas")
    public List<MatriculaResponseDto> getMatriculas() {
        List<Matricula> matriculas = matriculaService.findAll();
        ArrayList<MatriculaResponseDto> matriculaResponseDtos = new ArrayList<>();

        for (Matricula matricula : matriculas) {
            matriculaResponseDtos.add(MatriculaResponseDto.fromEntity(matricula));
        }

        return matriculaResponseDtos;
    }

    @GetMapping("/matriculas/{id}")
    public MatriculaResponseDto getMatricula(@PathVariable(value = "id") Long id) {
        Matricula matricula = matriculaService.findById(id);
        return MatriculaResponseDto.fromEntity(matricula);
    }

    @PostMapping("/matriculas")
    public MatriculaResponseDto create(@RequestBody MatriculaDto matriculaDto) {
        Matricula matricula = matriculaService.create(matriculaDto.toEntity());
        return MatriculaResponseDto.fromEntity(matricula);
    }

    @DeleteMapping("/matriculas/{id}")
    public void deleteMatricula(@PathVariable(value = "id") Long id) {
        matriculaService.deleteById(id);
    }
}
