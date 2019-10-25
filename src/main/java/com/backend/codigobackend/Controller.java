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

    @GetMapping("/perfil/{email}")
    public Pessoa perfil(@PathVariable("email") String email){
        return service.findByPessoa(email);
    }

    @PutMapping("/editar/{email}")
    public Pessoa editar(@RequestBody Pessoa pessoa, @PathVariable("email") String email){
        List<Pessoa> lista = service.listar();
        for (Pessoa p : lista) {
            if (p.getEmail().equals(email)) {
                p.setId(pessoa.getId());
                p.setCodSeg(pessoa.getCodSeg());
                p.setDataValidade(pessoa.getDataValidade());
                p.setEmail(pessoa.getEmail());
                p.setEmpresa(pessoa.getEmpresa());
                p.setNome(pessoa.getNome());
                p.setNomeNoCartao(pessoa.getNomeNoCartao());
                p.setNroCartao(pessoa.getNroCartao());
                p.setPaga(pessoa.isPaga());
                p.setQualidades(pessoa.getQualidades());
                p.setSenha(pessoa.getSenha());
                return service.edit(p);
            }
        }
        return pessoa;
    }
}
