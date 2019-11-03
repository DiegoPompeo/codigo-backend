package com.backend.codigobackend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
class Glossario {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy= "increment")
    private int id;

    private String nome;

    Glossario(String nome) {
        this.nome = nome;
    }
}
