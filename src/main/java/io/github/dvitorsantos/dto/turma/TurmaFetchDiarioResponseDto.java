package io.github.dvitorsantos.dto.turma;

import io.github.dvitorsantos.entity.Diario;
import io.github.dvitorsantos.entity.Turma;

import java.util.List;
import java.util.Set;

public class TurmaFetchDiarioResponseDto {
    private Long id;
    private String descricao;
    private Set<Diario> diarios;

    public TurmaFetchDiarioResponseDto(Long id, String descricao, Set<Diario> diarios) {
        this.id = id;
        this.descricao = descricao;
        this.diarios = diarios;
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

    public Set<Diario> getDiarios() {
        return diarios;
    }

    public void setDiarios(Set<Diario> diarios) {
        this.diarios = diarios;
    }

    public static TurmaFetchDiarioResponseDto fromEntity(Turma turma) {
        return new TurmaFetchDiarioResponseDto(turma.getId(), turma.getDescricao(), turma.getDiarios());
    }
}
