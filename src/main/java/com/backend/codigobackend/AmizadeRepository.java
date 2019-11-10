package com.backend.codigobackend;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface AmizadeRepository extends Repository<Amizade, Integer> {
    List<Amizade> findAll();
    List<Amizade> findByEmailMandatario(String emailMandatario);
    Amizade save(Amizade amizade);
    void delete(Amizade amizade);
}

