package com.backend.codigobackend;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface PessoaRepository extends Repository<Pessoa, Long> {
    List<Pessoa> findAll();
    Pessoa findById(long id);
    Pessoa save(Pessoa pessoa);
    Pessoa findByNome(String nome);
    boolean findByEmail(String email);
    Pessoa findByPessoa(String email);
}
