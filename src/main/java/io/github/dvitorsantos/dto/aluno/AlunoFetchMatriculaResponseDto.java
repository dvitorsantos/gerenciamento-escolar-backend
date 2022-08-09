package io.github.dvitorsantos.dto.aluno;

import io.github.dvitorsantos.dto.matricula.MatriculaResponseDto;
import io.github.dvitorsantos.entity.Aluno;
import io.github.dvitorsantos.entity.Matricula;

import java.util.Set;
import java.util.stream.Collectors;

public class AlunoFetchMatriculaResponseDto {
    private Long id;
    private String nome;
    private Set<MatriculaResponseDto> matriculas;

    public AlunoFetchMatriculaResponseDto(Long id, String nome, Set<MatriculaResponseDto> matriculas) {
        this.id = id;
        this.nome = nome;
        this.matriculas = matriculas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<MatriculaResponseDto> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(Set<MatriculaResponseDto> matriculas) {
        this.matriculas = matriculas;
    }

    public static AlunoFetchMatriculaResponseDto fromEntity(Aluno aluno) {
        Set<MatriculaResponseDto> matriculaResponseDto = aluno.getMatriculas().stream().map(MatriculaResponseDto::fromEntity).collect(Collectors.toSet());
        return new AlunoFetchMatriculaResponseDto(aluno.getId(), aluno.getNome(), matriculaResponseDto);
    }
}
