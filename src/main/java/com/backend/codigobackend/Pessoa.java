package com.backend.codigobackend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Column
    private Integer curtida;

}
