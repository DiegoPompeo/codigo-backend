package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlossarioServiceImpl implements GlossarioService{
    @Autowired
    private GlossarioRepository glossarioRepository;

    @Override
    public List<Glossario> listar() {
        return glossarioRepository.findAll();
    }

    @Override
    public Glossario encontrarId(int id) {
        return glossarioRepository.findById(id);
    }

    @Override
    public Glossario add(Glossario glossario) {
        return glossarioRepository.save(glossario);
    }

    @Override
    public void delete(Glossario glossario) {
        glossarioRepository.delete(glossario);
    }

    @Override
    public void deleteTodos() {
        glossarioRepository.deleteAll();
    }

    @Override
    public Glossario encontrarNome(String nome) {
        return glossarioRepository.findByNome(nome);
    }
}
