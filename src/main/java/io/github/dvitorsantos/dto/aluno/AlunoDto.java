package io.github.dvitorsantos.dto.aluno;

import io.github.dvitorsantos.entity.Aluno;

public class AlunoDto {
    private Long id;
    private String nome;

    public AlunoDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public Aluno toEntity() {
        return new Aluno(this.nome);
    }
}
