package io.github.dvitorsantos.config;

import io.github.dvitorsantos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioService usuarioService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/matriculas/**").hasRole("ADMIN")
                .antMatchers("/alunos/**").hasRole("ADMIN")
                .antMatchers("/turmas/**").hasRole("ADMIN")
                .antMatchers("/series/**").hasRole("ADMIN")
                .antMatchers("/periodos/**").hasRole("ADMIN")
                .antMatchers("/grades/**").hasRole("ADMIN")
                .antMatchers("/diarios/**").hasRole("ADMIN")
                .antMatchers("/disciplinas/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/usuarios/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();
    }
}
