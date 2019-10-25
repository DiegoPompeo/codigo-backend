package com.backend.codigobackend;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface PessoaRepository extends Repository<Pessoa, Integer> {
    List<Pessoa> findAll();
    Pessoa findById(int id);
    Pessoa save(Pessoa pessoa);
    Pessoa findByNome(String nome);
    boolean findByEmail(String email);
    Pessoa findByPessoa(String email);
}
