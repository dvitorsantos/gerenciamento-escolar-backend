package io.github.dvitorsantos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String senha;

    private Boolean admin;

    private String nome;

    private String sobrenome;

    private String email;

    private String cpf;

    private String telefone;

    private String cor;

    private String sexo;

    private String pais;

    private String estado;

    private String cidade;

    private String cep;

    private String rua;

    public Usuario(String nome, String sobrenome, String email, String cpf, String telefone, String cor, String sexo, String pais, String estado, String cidade, String cep, String rua) {
        this.login = login;
        this.senha = senha;
        this.admin = admin;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cor = cor;
        this.sexo = sexo;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.rua = rua;
    }
}
