package io.github.dvitorsantos.dto.aluno;

import io.github.dvitorsantos.entity.Aluno;
import io.github.dvitorsantos.entity.Usuario;

public class AlunoResponseDto {
    private Long id;

    private String nome;

    private String sobrenome;

    private String email;

    private String cpf;

    private String telefone;

    private String cor;

    private String sexo;

    private String pais;

    private String estado;

    private String cidade;

    private String cep;

    private String rua;

    public AlunoResponseDto(Long id, String nome, String sobrenome, String email, String cpf, String telefone, String cor, String sexo, String pais, String estado, String cidade, String cep, String rua) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cor = cor;
        this.sexo = sexo;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.rua = rua;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public static AlunoResponseDto fromEntity(Aluno aluno) {
        Usuario usuario = aluno.getUsuario();
        return new AlunoResponseDto(aluno.getId(), usuario.getNome(), usuario.getSobrenome(), usuario.getEmail(), usuario.getCpf(), usuario.getTelefone(), usuario.getCor(), usuario.getSexo(), usuario.getPais(), usuario.getEstado(), usuario.getCidade(), usuario.getCep(), usuario.getRua());
    }
}
