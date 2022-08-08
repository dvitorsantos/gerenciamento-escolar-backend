package io.github.dvitorsantos.service;

import io.github.dvitorsantos.entity.Diario;
import io.github.dvitorsantos.repository.DiarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DiarioService {
    private final DiarioRepository diarioRepository;

    public DiarioService(DiarioRepository diarioRepository) {
        this.diarioRepository = diarioRepository;
    }

    public List<Diario> findAll() {
        return diarioRepository.findAll();
    }

    public Diario findById(Long id) {
        return diarioRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "diario not found"));
    }

    public Diario save(Diario diario) {
        return diarioRepository.save(diario);
    }

    public void deleteById(Long id) {
        diarioRepository.deleteById(id);
    }

    public Diario update(Long id, Diario diario) {
        Diario diarioExistente = diarioRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "diario not found"));
        diarioExistente.setDescricao(diario.getDescricao());
        return diarioRepository.save(diarioExistente);
    }
}
