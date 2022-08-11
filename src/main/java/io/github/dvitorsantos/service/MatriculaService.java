package io.github.dvitorsantos.service;

import io.github.dvitorsantos.entity.Aluno;
import io.github.dvitorsantos.entity.Matricula;
import io.github.dvitorsantos.entity.Periodo;
import io.github.dvitorsantos.entity.Turma;
import io.github.dvitorsantos.repository.AlunoRepository;
import io.github.dvitorsantos.repository.MatriculaRepository;
import io.github.dvitorsantos.repository.PeriodoRepository;
import io.github.dvitorsantos.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MatriculaService {
    @Autowired
    private final MatriculaRepository matriculaRepository;

    @Autowired
    private final AlunoRepository alunoRepository;

    @Autowired
    private final TurmaRepository turmaRepository;

    @Autowired
    private final PeriodoRepository periodoRepository;

    public MatriculaService(MatriculaRepository matriculaRepository, AlunoRepository alunoRepository, TurmaRepository turmaRepository, PeriodoRepository periodoRepository) {
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
        this.periodoRepository = periodoRepository;
    }

    public List<Matricula> findAll() {
        return matriculaRepository.findAll();
    }

    public Matricula findById(Long id) {
        return matriculaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "matricula not found"));
    }

    public Matricula create(@RequestBody Matricula matricula) {
        Aluno aluno = alunoRepository
                .findById(matricula.getAluno().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "aluno not found"));

        Turma turma = turmaRepository
                .findById(matricula.getTurma().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "turma not found"));

        Periodo periodo = periodoRepository
                .findById(matricula.getPeriodo().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "periodo not found"));

        return matriculaRepository.save(new Matricula(aluno, turma, periodo));
    }

    public Matricula save(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    public void deleteById(Long id) {
        matriculaRepository.deleteById(id);
    }

    public Matricula update(Long id, Matricula matricula) {
        Matricula matriculaExistente = matriculaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "matricula not found"));
        matriculaExistente.setMatricula(matricula.getMatricula());
        return matriculaRepository.save(matriculaExistente);
    }
}
