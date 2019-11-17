package com.backend.codigobackend;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface PessoaRecomendadaRepository extends Repository<PessoaRecomendada, Integer> {
    List<PessoaRecomendada> findAll();
    PessoaRecomendada findById(int id);
    PessoaRecomendada save(PessoaRecomendada pessoa);
    void delete(PessoaRecomendada pessoa);
    boolean findByEmailRecomendou(String emailRecomendou);
}
