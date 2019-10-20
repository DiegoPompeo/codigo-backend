package com.backend.codigobackend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    private String nome;

    private String email;

    private String senha;

    private String nroCartao;

    private String nomeNoCartao;

    private String dataValidade;

    private String codSeg;

    private String empresa;

    private String qualidades;

    private boolean paga;
}