package io.github.dvitorsantos.service;

import io.github.dvitorsantos.entity.Serie;
import io.github.dvitorsantos.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SerieService {
    @Autowired
    private final SerieRepository serieRepository;

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public List<Serie> findAll() {
        return serieRepository.findAll();
    }

    public Serie findById(Long id) {
        return serieRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "serie not found"));
    }

    public Serie save(Serie serie) {
        return serieRepository.save(serie);
    }

    public void deleteById(Long id) {
        serieRepository.deleteById(id);
    }

    public Serie update(Long id, Serie serie) {
        Serie serieExistente = serieRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "serie not found"));
        serieExistente.setDescricao(serie.getDescricao());
        return serieRepository.save(serieExistente);
    }
}
