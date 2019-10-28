package com.backend.codigobackend;

import java.util.List;

public interface PessoaRecomendadaService {
    PessoaRecomendada add(PessoaRecomendada pessoaRecomendada);
    List<PessoaRecomendada> listar();
}
