package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmizadeServiceImp implements AmizadeService {
    @Autowired
    private AmizadeRepository amizadeRepository;

    @Override
    public List<Amizade> listarAmizade() {
        return amizadeRepository.findAll();
    }

    @Override
    public List<Amizade> listarEmail(String emailMandatario) {
        return amizadeRepository.findByEmailMandatario(emailMandatario);
    }


    @Override
    public Amizade add(Amizade amizade) {
        return amizadeRepository.save(amizade);
    }

    @Override
    public Amizade edit(Amizade amizade) {
        return amizadeRepository.save(amizade);
    }

    @Override
    public void delete(Amizade amizade) {
        amizadeRepository.delete(amizade);
    }
}


