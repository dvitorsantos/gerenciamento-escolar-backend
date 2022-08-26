package io.github.dvitorsantos.security.jwt;

import io.github.dvitorsantos.entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {
    @Value("${security.jwt.expiration}")
    private String expiration;
    @Value("${security.jwt.secret}")
    private String secret;

    public String generateToken(Usuario usuario) {
        long expirationTime = Long.valueOf(expiration);
        LocalDateTime localDateTimeExpiration = LocalDateTime.now().plusMinutes(expirationTime);
        Instant instant = localDateTimeExpiration.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        return Jwts
                .builder()
                .setSubject(usuario.getLogin())
                .setExpiration(date)
                .signWith( SignatureAlgorithm.HS512, secret )
                .compact();
    }

    public Claims getClaims(String token) throws ExpiredJwtException {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isValid(String token) {
        try {
            this.getClaims(token);
            return true;
        } catch (ExpiredJwtException e) {
            return false;
        }
    }

    public String getUser(String token) {
        return (String) this.getClaims(token).getSubject();
    }

    public Usuario getUsuario(String token) {
        return Usuario.builder()
                .login(this.getUser(token))
                .build();
    }
}
