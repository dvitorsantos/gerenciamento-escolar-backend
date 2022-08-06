package io.github.dvitorsantos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.dvitorsantos.entity.Matricula;


public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

}
