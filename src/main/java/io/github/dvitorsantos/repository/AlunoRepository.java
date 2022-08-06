package io.github.dvitorsantos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.dvitorsantos.entity.Aluno;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findById(Long id);
}
