package io.github.dvitorsantos.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="turma")
public class Turma  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @OneToMany(mappedBy = "turma")
    private List<Diario> diarios;

    @OneToMany(mappedBy = "turma")
    private List<Matricula> matriculas;

    @ManyToMany()
    @JoinTable(
            name = "turma_aluno",
            joinColumns = @JoinColumn(name = "id_turma"),
            inverseJoinColumns = @JoinColumn(name = "id_aluno"))
    List<Aluno> alunos;

    @Deprecated
    public Turma() {
    }

    public Turma(Long id_turma) {
        this.id = id_turma;
    }

    public Turma(Long id, String descricao, List<Diario> diarios, List<Matricula> matriculas, List<Aluno> alunos) {
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


    public List<Diario> getDiarios() {
        return this.diarios;
    }
}
