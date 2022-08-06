package io.github.dvitorsantos.entity;

import javax.persistence.*;

@Entity
@Table(name = "matricula", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "id_aluno", "id_turma"
        })
})
public class Matricula {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;

    @Deprecated
    public Matricula() {
    }

    public Matricula(Aluno aluno, Turma turma) {
        this.aluno = aluno;
        this.turma = turma;
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
}
