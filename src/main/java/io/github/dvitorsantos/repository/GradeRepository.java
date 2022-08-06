package io.github.dvitorsantos.repository;

import io.github.dvitorsantos.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    Optional<Grade> findById(Long id);
}
