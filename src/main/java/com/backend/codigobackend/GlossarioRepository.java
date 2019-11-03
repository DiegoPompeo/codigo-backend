package com.backend.codigobackend;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface GlossarioRepository extends Repository<Glossario, Integer> {
    List<Glossario> findAll();
    Glossario findById(int id);
    Glossario save(Glossario glossario);
    void delete(Glossario glossario);
    Glossario findByNome(String nome);
    void deleteAll();
}
