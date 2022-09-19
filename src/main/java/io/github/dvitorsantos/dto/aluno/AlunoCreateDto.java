package io.github.dvitorsantos.dto.aluno;

import io.github.dvitorsantos.dto.usuario.UsuarioCreateDto;
import io.github.dvitorsantos.entity.Aluno;
import io.github.dvitorsantos.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoCreateDto {
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

    public Aluno toEntity() {
        return new Aluno();
    }

    public UsuarioCreateDto toUsuarioCreateDto() {
        return new UsuarioCreateDto(nome, sobrenome, email, cpf, telefone, cor, sexo, pais, estado, cidade, cep, rua);
    }
}
