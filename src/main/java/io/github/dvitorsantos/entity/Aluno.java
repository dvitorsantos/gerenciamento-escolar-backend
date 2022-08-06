package io.github.dvitorsantos.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="aluno")
public class Aluno {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "aluno")
    private List<Matricula> matriculas;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
