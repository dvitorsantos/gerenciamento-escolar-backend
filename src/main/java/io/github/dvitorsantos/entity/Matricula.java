package io.github.dvitorsantos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "matricula", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "id_aluno", "id_turma", "id_periodo"
        })
})
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @ManyToOne()
    @JoinColumn(name = "id_turma")
    private Turma turma;

    private String matricula;

    @ManyToOne
    @JoinColumn(name = "id_periodo")
    private Periodo periodo;

    private String situacao;

    @Deprecated
    public Matricula() {
    }

    public Matricula(Aluno aluno, Turma turma, Periodo periodo) {
        this.aluno = aluno;
        this.turma = turma;
        this.periodo = periodo;
        this.matricula = this.geraMatricula(aluno, turma, periodo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public String geraMatricula(Aluno aluno, Turma turma, Periodo periodo) {
        return periodo.getDescricao() + turma.getId() + aluno.getId();
    }
}
