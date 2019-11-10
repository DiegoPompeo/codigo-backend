package com.backend.codigobackend;

import java.util.List;

public interface AmizadeService {
    List<Amizade> listarAmizade();
    List<Amizade> listarEmail(String emailMandatario);
    Amizade add(Amizade amizade);
    Amizade edit(Amizade amizade);
    void delete(Amizade amizade);
}
