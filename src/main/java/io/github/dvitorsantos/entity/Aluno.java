package io.github.dvitorsantos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "aluno")
    private Set<Matricula> matriculas;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Matricula> getMatriculas() {
        return this.matriculas;
    }

    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
