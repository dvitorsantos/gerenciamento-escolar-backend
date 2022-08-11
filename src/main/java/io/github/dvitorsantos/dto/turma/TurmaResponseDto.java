package io.github.dvitorsantos.dto.turma;

import io.github.dvitorsantos.entity.Diario;
import io.github.dvitorsantos.entity.Turma;

import javax.persistence.OneToMany;
import java.util.List;

public class TurmaResponseDto {

    private Long id;

    private String descricao;

    public TurmaResponseDto(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static TurmaResponseDto fromEntity(Turma turma) {
        return new TurmaResponseDto(turma.getId(), turma.getDescricao());
    }
}
