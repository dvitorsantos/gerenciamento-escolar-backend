package io.github.dvitorsantos.service;

import io.github.dvitorsantos.entity.Periodo;
import io.github.dvitorsantos.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PeriodoService {
    @Autowired
    private final PeriodoRepository periodoRepository;

    public PeriodoService(PeriodoRepository periodoRepository) {
        this.periodoRepository = periodoRepository;
    }

    public List<Periodo> findAll() {
        return periodoRepository.findAll();
    }

    public Periodo findById(Long id) {
        return periodoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "periodo not found"));
    }

    public Periodo save(Periodo periodo) {
        return periodoRepository.save(periodo);
    }

    public void deleteById(Long id) {
        periodoRepository.deleteById(id);
    }

    public Periodo update(Long id, Periodo periodo) {
        Periodo periodoExistente = periodoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "periodo not found"));
        periodoExistente.setDescricao(periodo.getDescricao());
        return periodoRepository.save(periodoExistente);
    }
}
