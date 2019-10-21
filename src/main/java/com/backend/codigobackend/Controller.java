package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redesocial")
public class Controller {
    @Autowired
    private PessoaService service;

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
        for (Pessoa pessoa : lista) {
            if (pessoa.getEmail().equals(email) && pessoa.getSenha().equals(senha)) {
                return pessoa;
            }
        }
        return null;
    }

    @GetMapping("/email/{email}")
    public boolean verifica(@PathVariable("email") String email){
        List<Pessoa> lista = service.listar();
        for (Pessoa pessoa : lista) {
            if (pessoa.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @GetMapping("/buscar/{email}")
    public Pessoa busca(@PathVariable("email") String email){
        List<Pessoa> lista = service.listar();
        for (Pessoa pessoa : lista) {
            if (pessoa.getEmail().equals(email)) {
                return pessoa;
            }
        }
        return null;
    }

    @GetMapping("/perfil/{id}")
    public Pessoa perfil(@PathVariable("id") int id){
        return service.listarId(id);
    }

    @PutMapping("/editar/{id}")
    public Pessoa editar(@RequestBody Pessoa p, @PathVariable("id") long id){
        Pessoa pessoa = service.listarId(id);
        p.setCodSeg(p.getCodSeg());
        p.setDataValidade(p.getDataValidade());
        p.setEmail(p.getEmail());
        p.setEmpresa(p.getEmpresa());
        p.setNome(p.getNome());
        p.setNomeNoCartao(p.getNomeNoCartao());
        p.setNroCartao(p.getNroCartao());
        p.setPaga(p.isPaga());
        p.setQualidades(p.getQualidades());
        p.setSenha(p.getSenha());
        return service.edit(p);
    }
}
