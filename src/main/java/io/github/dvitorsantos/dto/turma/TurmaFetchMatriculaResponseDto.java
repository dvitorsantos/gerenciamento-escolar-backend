package io.github.dvitorsantos.dto.turma;

import io.github.dvitorsantos.entity.Matricula;
import io.github.dvitorsantos.entity.Turma;

public class TurmaFetchMatriculaResponseDto {
    private Long id;
    private String matricula;

    private Turma turma;

    public TurmaFetchMatriculaResponseDto(Long id, String matricula, Turma turma) {
        this.id = id;
        this.matricula = matricula;
        this.turma = turma;
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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public static TurmaFetchMatriculaResponseDto fromEntity(Matricula matricula) {
        return new TurmaFetchMatriculaResponseDto(matricula.getId(), matricula.getMatricula(), matricula.getTurma());
    }
}


