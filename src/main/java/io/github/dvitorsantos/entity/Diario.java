package io.github.dvitorsantos.entity;

import javax.persistence.*;

@Entity
@Table(name="diario")
public class Diario {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String descricao;

        @ManyToOne
        @JoinColumn(name = "id_turma")
        private Turma turma;

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
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
}
