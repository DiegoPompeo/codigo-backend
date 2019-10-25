package com.backend.codigobackend;

import java.util.List;

public interface PessoaService {
    List<Pessoa> listar();
    Pessoa listarId(int id);
    Pessoa add(Pessoa p);
    Pessoa edit(Pessoa p);
    void delete(long id);
    Pessoa findNome(String nome);
    boolean findByEmail(String email);
    Pessoa findByPessoa(String email);
}
