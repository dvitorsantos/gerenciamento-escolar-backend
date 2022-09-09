package io.github.dvitorsantos.dto.aluno;

import io.github.dvitorsantos.entity.Aluno;

public class AlunoResponseDto {
    private Long id;

    public AlunoResponseDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static AlunoResponseDto fromEntity(Aluno aluno) {
        return new AlunoResponseDto(aluno.getId());
    }
}
