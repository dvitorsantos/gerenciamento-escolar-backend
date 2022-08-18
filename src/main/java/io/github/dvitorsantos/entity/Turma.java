package io.github.dvitorsantos.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="turma")
public class Turma  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_periodo")
    private Periodo periodo;

    @OneToMany(mappedBy = "turma")
    private Set<Diario> diarios;

    @OneToMany(mappedBy = "turma")
    private Set<Matricula> matriculas;

    @ManyToMany()
    @JoinTable(
            name = "turma_aluno",
            joinColumns = @JoinColumn(name = "id_turma"),
            inverseJoinColumns = @JoinColumn(name = "id_aluno"))
    Set<Aluno> alunos;

    @Deprecated
    public Turma() {
    }

    public Turma(Long id_turma) {
        this.id = id_turma;
    }

    public Turma(Long id, String descricao, Set<Diario> diarios, Set<Matricula> matriculas, Set<Aluno> alunos) {
        this.id = id;
        this.descricao = descricao;
        this.diarios = diarios;
        this.matriculas = matriculas;
        this.alunos = alunos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Diario> getDiarios() {
        return this.diarios;
    }

    public void setDiarios(Set<Diario> diarios) {
        this.diarios = diarios;
    }

    public Set<Matricula> getMatriculas() {
        return this.matriculas;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
