package io.github.dvitorsantos.controller;

import io.github.dvitorsantos.dto.aluno.AlunoCreateDto;
import io.github.dvitorsantos.dto.aluno.AlunoFetchMatriculaResponseDto;
import io.github.dvitorsantos.dto.aluno.AlunoResponseDto;
import io.github.dvitorsantos.dto.usuario.UsuarioCreateDto;
import io.github.dvitorsantos.entity.Usuario;
import io.github.dvitorsantos.service.AlunoService;
import io.github.dvitorsantos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.github.dvitorsantos.entity.Aluno;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AlunoController {

    @Autowired
    private final AlunoService alunoService;

    @Autowired
    private final UsuarioService usuarioService;

    public AlunoController(AlunoService alunoService, UsuarioService usuarioService) {
        this.alunoService = alunoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/alunos")
    @ResponseBody
    public List<AlunoResponseDto> getAlunos() {
        List<Aluno> alunos = alunoService.findAllFetchUsuario();
        ArrayList<AlunoResponseDto> alunoResponseDtos = new ArrayList<>();

        for (Aluno aluno : alunos) {
            alunoResponseDtos.add(AlunoResponseDto.fromEntity(aluno));
        }

        return alunoResponseDtos;
    }

    @GetMapping("/alunos/{id}")
    @ResponseBody
    public AlunoResponseDto getAluno(@PathVariable(value = "id") Long id) {
        Aluno aluno = alunoService.findById(id);
        return AlunoResponseDto.fromEntity(aluno);
    }

    @PostMapping("/alunos")
    public AlunoResponseDto createAluno(@RequestBody AlunoCreateDto alunoCreateDto) {
        UsuarioCreateDto usuarioDto = alunoCreateDto.toUsuarioCreateDto();

        Aluno aluno = alunoCreateDto.toEntity();
        Usuario usuario = usuarioDto.toEntity();

        usuario.setLogin(usuario.getEmail());
        usuario.setSenha(usuario.getCpf());
        usuario.setAdmin(false);

        try {
            Usuario usuarioCreated = usuarioService.save(usuario);
            aluno.setUsuario(usuarioCreated);
            alunoService.save(aluno);
        } catch (Exception e) {
            System.out.println(e);
        }

        return AlunoResponseDto.fromEntity(aluno);
    }

    @DeleteMapping("/alunos/{id}")
    public void deleteAluno(@PathVariable(value = "id") Long id) {
        alunoService.deleteById(id);
    }

    @PutMapping("/alunos/{id}")
    public AlunoResponseDto updateAluno(@PathVariable(value = "id") Long id, @RequestBody Aluno updatedAluno) {
        Aluno aluno = alunoService.update(id, updatedAluno);
        return AlunoResponseDto.fromEntity(aluno);
    }

    @GetMapping("/alunos/{id}/matriculas")
    @ResponseBody
    public AlunoFetchMatriculaResponseDto getAlunoFetchMatriculas(@PathVariable(value = "id") Long id) {
        Aluno aluno = alunoService.findByIdFetchMatriculas(id);
        return AlunoFetchMatriculaResponseDto.fromEntity(aluno);
    }
}

