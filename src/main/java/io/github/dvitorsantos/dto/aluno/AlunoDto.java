package io.github.dvitorsantos.dto.aluno;

import io.github.dvitorsantos.entity.Aluno;

public class AlunoDto {
    private Long id;

    public AlunoDto(Long id, String nome) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno toEntity() {
        return new Aluno(this.id);
    }
}
