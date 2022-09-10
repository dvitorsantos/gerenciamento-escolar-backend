package io.github.dvitorsantos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.dvitorsantos.entity.Aluno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findById(Long id);

    @Query ("SELECT a FROM Aluno a LEFT JOIN FETCH a.matriculas WHERE a.id = :id")
    Aluno findByIdFetchMatriculas(@Param("id") Long id);

    @Query ("SELECT a FROM Aluno a JOIN FETCH a.usuario")
    List<Aluno> findAllFetchUsuario();
}
