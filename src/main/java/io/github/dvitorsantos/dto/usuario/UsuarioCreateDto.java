package io.github.dvitorsantos.dto.usuario;

import io.github.dvitorsantos.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCreateDto {
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


    public Usuario toEntity() {
        return new Usuario(nome, sobrenome, email, cpf, telefone, cor, sexo, pais, estado, cidade, cep);
    }
}
