package io.github.dvitorsantos.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {
    private UsuarioPlainDto usuario;
    private String token;
}
