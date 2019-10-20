package com.backend.codigobackend;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface PessoaRepository extends Repository<Pessoa, Integer> {
    List<Pessoa> findAll();
    Pessoa findById(int id);
    Pessoa save(Pessoa pessoa);
    void delete(Pessoa pessoa);
    Pessoa findByNome(String nome);
    boolean findByEmail(String email);
}
