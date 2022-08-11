package io.github.dvitorsantos.dto.turma;

import io.github.dvitorsantos.entity.Diario;
import io.github.dvitorsantos.entity.Turma;

import java.util.List;

public class TurmaFetchDiarioResponseDto {
    private Long id;
    private String descricao;
    private List<Diario> diarios;

    public TurmaFetchDiarioResponseDto(Long id, String descricao, List<Diario> diarios) {
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

    public List<Diario> getDiarios() {
        return diarios;
    }

    public void setDiarios(List<Diario> diarios) {
        this.diarios = diarios;
    }

    public static TurmaFetchDiarioResponseDto fromEntity(Turma turma) {
        return new TurmaFetchDiarioResponseDto(turma.getId(), turma.getDescricao(), turma.getDiarios());
    }
}
