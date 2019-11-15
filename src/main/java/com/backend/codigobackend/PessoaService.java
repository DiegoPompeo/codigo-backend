package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class PessoaService {
    @Autowired
    private PessoaRepository repository;

    List<Pessoa> listar(){
        return repository.findAll();
    }
    Pessoa listarId(int id){
        return repository.findById(id);
    }
    Pessoa add(Pessoa p){
        return repository.save(p);
    }
    Pessoa edit(Pessoa p){
        return repository.save(p);
    }
    List<Pessoa> findNome(String nome){
        return repository.findByNome(nome);
    }
    boolean findByEmail(String email){
        return repository.findByEmail(email);
    }
}
