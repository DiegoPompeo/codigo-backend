package com.backend.codigobackend;

import java.util.List;

public interface GlossarioService {
    List<Glossario> listar();
    Glossario encontrarId(int id);
    Glossario add(Glossario glossario);
    void delete(Glossario glossario);
    Glossario encontrarNome(String nome);
}
