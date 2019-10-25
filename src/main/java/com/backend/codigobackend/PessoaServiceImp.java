package com.backend.codigobackend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImp implements PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Override
    public List<Pessoa> listar() {
        return repository.findAll();
    }

    @Override
    public Pessoa listarId(int id) {
        return repository.findById(id);
    }

    @Override
    public Pessoa add(Pessoa p) {
        return repository.save(p);
    }

    @Override
    public Pessoa edit(Pessoa p) {
        Pessoa pessoa = repository.findById(p.getId());
        if (pessoa != null){
            repository.save(pessoa);
        }
        return p;
    }

    @Override
    public Pessoa findNome(String nome) {
        return repository.findByNome(nome);
    }

    @Override
    public boolean findByEmail(String email) {
        return repository.findByEmail(email);
    }


}
