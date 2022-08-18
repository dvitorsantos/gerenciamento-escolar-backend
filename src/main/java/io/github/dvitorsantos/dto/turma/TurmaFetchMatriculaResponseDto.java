package io.github.dvitorsantos.dto.turma;

import io.github.dvitorsantos.dto.matricula.MatriculaDto;
import io.github.dvitorsantos.dto.matricula.MatriculaResponseDto;
import io.github.dvitorsantos.entity.Matricula;
import io.github.dvitorsantos.entity.Turma;

import java.util.Set;
import java.util.stream.Collectors;

public class TurmaFetchMatriculaResponseDto {
    private Long id;

    private String descricao;

    private Set<MatriculaResponseDto> matriculas;

    public TurmaFetchMatriculaResponseDto(Long id, String descricao, Set<MatriculaResponseDto> matriculas) {
        this.id = id;
        this.descricao = descricao;
        this.matriculas = matriculas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<MatriculaResponseDto> getMatriculas() {
        return this.matriculas;
    }

    public void setTurmas(Set<MatriculaResponseDto> turmas) {
        this.matriculas = turmas;
    }

    public static TurmaFetchMatriculaResponseDto fromEntity(Turma turma) {
        Set<MatriculaResponseDto> matriculaPlainDto = turma.getMatriculas().stream().map(MatriculaResponseDto::fromEntity).collect(Collectors.toSet());
        return new TurmaFetchMatriculaResponseDto(turma.getId(), turma.getDescricao(), matriculaPlainDto);
    }
}


