package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class Controller {
    @Autowired
    PessoaService service;

    @GetMapping("")
    public List<Pessoa> lista(){
        return service.listar();
    }

    @PostMapping("/signup")
    public Pessoa adiciona(@RequestBody Pessoa p){
        return service.add(p);
    }

    @PostMapping("/login")
    public Pessoa login(@RequestBody Pessoa p){
        List<Pessoa> lista = service.listar();
        String email = p.getEmail();
        String senha = p.getSenha();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getEmail().equals(email) && lista.get(i).getSenha().equals(senha)){
                p.setId(lista.get(i).getId());
                return p;
            }
        }
        return null;
    }

    @GetMapping("/email/{email}")
    public boolean verifica(@PathVariable("email") String email){
        List<Pessoa> lista = service.listar();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    @GetMapping("/buscar/{email}")
    public Pessoa busca(@PathVariable("email") String email){
        List<Pessoa> lista = service.listar();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getEmail().equals(email)){
                return lista.get(i);
            }
        }
        return null;
    }

    @GetMapping("/{id}")
    public Pessoa perfil(@PathVariable("id") int id){
        return service.listarId(id);
    }

    @PutMapping("/{id}")
    public Pessoa editar(@RequestBody Pessoa p, @PathVariable("id") int id){
        p.setId(id);
        return service.edit(p);
    }
}
