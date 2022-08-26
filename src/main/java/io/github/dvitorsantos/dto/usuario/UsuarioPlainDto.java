package io.github.dvitorsantos.dto.usuario;

import io.github.dvitorsantos.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPlainDto {
    private Long id;
    private String email;
    private String login;

    public static UsuarioPlainDto fromEntity(Usuario usuario) {
        return new UsuarioPlainDto(usuario.getId(), usuario.getEmail(), usuario.getLogin());
    }
}
