package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
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
    public Pessoa editar(@RequestBody Pessoa pessoa, @PathVariable("id") int id){
        Pessoa p = service.listarId(id);
        p.setEmail(pessoa.getEmail());
        p.setSenha(pessoa.getSenha());
        p.setQualidades(pessoa.getQualidades());
        p.setPaga(pessoa.isPaga());
        p.setNroCartao(pessoa.getNroCartao());
        p.setNomeNoCartao(pessoa.getNomeNoCartao());
        p.setDataValidade(pessoa.getDataValidade());
        p.setNome(pessoa.getNome());
        p.setCodSeg(pessoa.getCodSeg());
        p.setEmpresa(pessoa.getEmpresa());
        return service.edit(p);
    }

}
