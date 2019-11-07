package com.backend.codigobackend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class Pessoa {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @NotBlank
    private String nome;

    @Email
    private String email;

    private String interesse;

    @NotBlank
    private String senha;

    private String nroCartao;

    private String nomeNoCartao;

    private String dataValidade;

    private String codSeg;

    @NotBlank
    private String empresa;

    @NotBlank
    private String inicioDaAtividade;

    @NotBlank
    private String dataNascimento;

    @NotBlank
    private String nivelEscolaridade;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private boolean paga;
}
