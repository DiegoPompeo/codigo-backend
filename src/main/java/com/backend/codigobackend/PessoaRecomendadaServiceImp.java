package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaRecomendadaServiceImp implements PessoaRecomendadaService{

    @Autowired
    private PessoaRecomendadaRepository repository;


    @Override
    public PessoaRecomendada add(PessoaRecomendada pessoaRecomendada) {
        return repository.save(pessoaRecomendada);
    }

    @Override
    public PessoaRecomendada edit(PessoaRecomendada pessoaRecomendada) {
        return repository.save(pessoaRecomendada);
    }

    @Override
    public List<PessoaRecomendada> listar() {
        return repository.findAll();
    }


}
