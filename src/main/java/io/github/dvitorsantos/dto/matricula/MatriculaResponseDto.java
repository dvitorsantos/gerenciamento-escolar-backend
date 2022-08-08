package io.github.dvitorsantos.dto.matricula;

import io.github.dvitorsantos.entity.Matricula;

public class MatriculaResponseDto {
    private Long id;
    private String matricula;
    private Long id_aluno;
    private Long id_turma;

    public MatriculaResponseDto(Long id, String matricula, Long id_aluno, Long id_turma) {
        this.id = id;
        this.matricula = matricula;
        this.id_aluno = id_aluno;
        this.id_turma = id_turma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Long getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(Long id_aluno) {
        this.id_aluno = id_aluno;
    }

    public Long getId_turma() {
        return id_turma;
    }

    public void setId_turma(Long id_turma) {
        this.id_turma = id_turma;
    }

    public static MatriculaResponseDto fromEntity(Matricula matricula) {
        return new MatriculaResponseDto(matricula.getId(), matricula.getMatricula(), matricula.getAluno().getId(), matricula.getTurma().getId());
    }
}
