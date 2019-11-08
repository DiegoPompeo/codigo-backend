package com.backend.codigobackend;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
class Pessoa {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    private String nome;

    @Email
    private String email;

    private String interesse;

    private String senha;

    private String nroCartao;

    private String nomeNoCartao;

    private String dataValidade;

    private String codSeg;

    private String empresa;

    private String inicioDaAtividade;

    private String dataNascimento;

    private String nivelEscolaridade;

    private String cidade;

    private String estado;

    private boolean paga;

    Pessoa() {
    }

    Pessoa(int id, String nome, @Email String email, String interesse, String senha, String nroCartao, String nomeNoCartao, String dataValidade, String codSeg, String empresa, String inicioDaAtividade, String dataNascimento, String nivelEscolaridade, String cidade, String estado, boolean paga) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.interesse = interesse;
        this.senha = senha;
        this.nroCartao = nroCartao;
        this.nomeNoCartao = nomeNoCartao;
        this.dataValidade = dataValidade;
        this.codSeg = codSeg;
        this.empresa = empresa;
        this.inicioDaAtividade = inicioDaAtividade;
        this.dataNascimento = dataNascimento;
        this.nivelEscolaridade = nivelEscolaridade;
        this.cidade = cidade;
        this.estado = estado;
        this.paga = paga;
    }

    private int getId() {
        return id;
    }

    private String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private String getInteresse() {
        return interesse;
    }

    private void setInteresse(String interesse) {
        this.interesse = interesse;
    }

    private String getSenha() {
        return senha;
    }

    private void setSenha(String senha) {
        this.senha = senha;
    }

    private String getNroCartao() {
        return nroCartao;
    }

    private void setNroCartao(String nroCartao) {
        this.nroCartao = nroCartao;
    }

    private String getNomeNoCartao() {
        return nomeNoCartao;
    }

    private void setNomeNoCartao(String nomeNoCartao) {
        this.nomeNoCartao = nomeNoCartao;
    }

    private String getDataValidade() {
        return dataValidade;
    }

    private void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    private String getCodSeg() {
        return codSeg;
    }

    private void setCodSeg(String codSeg) {
        this.codSeg = codSeg;
    }

    private String getEmpresa() {
        return empresa;
    }

    private void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    private String getInicioDaAtividade() {
        return inicioDaAtividade;
    }

    private void setInicioDaAtividade(String inicioDaAtividade) {
        this.inicioDaAtividade = inicioDaAtividade;
    }

    private String getDataNascimento() {
        return dataNascimento;
    }

    private void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    private String getNivelEscolaridade() {
        return nivelEscolaridade;
    }

    private void setNivelEscolaridade(String nivelEscolaridade) {
        this.nivelEscolaridade = nivelEscolaridade;
    }

    private String getCidade() {
        return cidade;
    }

    private void setCidade(String cidade) {
        this.cidade = cidade;
    }

    private String getEstado() {
        return estado;
    }

    private void setEstado(String estado) {
        this.estado = estado;
    }

    private boolean isPaga() {
        return paga;
    }

    private void setPaga(boolean paga) {
        this.paga = paga;
    }
}
