package com.backend.codigobackend;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
class PessoaRecomendada {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    private String email;

    private String emailRecomendada;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailRecomendada() {
        return emailRecomendada;
    }

    public void setEmailRecomendada(String emailRecomendada) {
        this.emailRecomendada = emailRecomendada;
    }

    public PessoaRecomendada(int id, String email, String emailRecomendada) {
        this.id = id;
        this.email = email;
        this.emailRecomendada = emailRecomendada;
    }

    public PessoaRecomendada() {
    }
}
