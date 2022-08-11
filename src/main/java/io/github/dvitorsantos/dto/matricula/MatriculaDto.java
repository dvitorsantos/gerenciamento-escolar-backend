package io.github.dvitorsantos.dto.matricula;

import io.github.dvitorsantos.entity.Aluno;
import io.github.dvitorsantos.entity.Matricula;
import io.github.dvitorsantos.entity.Periodo;
import io.github.dvitorsantos.entity.Turma;

public class MatriculaDto {
    private Long id_aluno;
    private Long id_turma;

    private Long id_periodo;

    public MatriculaDto(Long id_aluno, Long id_turma, Long id_periodo) {
        this.id_aluno = id_aluno;
        this.id_turma = id_turma;
        this.id_periodo = id_periodo;
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

    public Matricula toEntity() {
        return new Matricula(new Aluno(this.id_aluno), new Turma(this.id_turma), new Periodo(this.id_periodo));
    }
}
