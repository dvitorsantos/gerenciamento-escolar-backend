package io.github.dvitorsantos.dto.aluno;

import io.github.dvitorsantos.dto.matricula.MatriculaResponseDto;
import io.github.dvitorsantos.entity.Aluno;

import java.util.Set;
import java.util.stream.Collectors;

public class AlunoFetchMatriculaResponseDto {
    private Long id;
    private Set<MatriculaResponseDto> matriculas;

    public AlunoFetchMatriculaResponseDto(Long id, Set<MatriculaResponseDto> matriculas) {
        this.id = id;
        this.matriculas = matriculas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<MatriculaResponseDto> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(Set<MatriculaResponseDto> matriculas) {
        this.matriculas = matriculas;
    }

    public static AlunoFetchMatriculaResponseDto fromEntity(Aluno aluno) {
        Set<MatriculaResponseDto> matriculaResponseDto = aluno.getMatriculas().stream().map(MatriculaResponseDto::fromEntity).collect(Collectors.toSet());
        return new AlunoFetchMatriculaResponseDto(aluno.getId(), matriculaResponseDto);
    }
}
