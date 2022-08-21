package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.dto.usuario.CredentialsDto;
import io.github.dvitorsantos.dto.usuario.TokenDto;
import io.github.dvitorsantos.entity.Usuario;
import io.github.dvitorsantos.exception.InvalidPasswordException;
import io.github.dvitorsantos.security.jwt.JwtService;
import io.github.dvitorsantos.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final JwtService jwtService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PostMapping("/auth")
    public TokenDto authenticate(@RequestBody CredentialsDto credentials) {
        try {
            Usuario usuario = Usuario.builder()
                    .login(credentials.getLogin())
                    .senha(credentials.getSenha())
                    .build();

            UserDetails usuarioAutenticado = usuarioService.authenticate(usuario);
            String token = jwtService.generateToken(usuario);
            return new TokenDto(usuario.getLogin(), token);
        } catch (UsernameNotFoundException | InvalidPasswordException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
