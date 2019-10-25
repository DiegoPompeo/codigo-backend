package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Pessoa> perfil(@PathVariable("id") long id){
        return ResponseEntity.ok().body(service.listarId(id));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Pessoa> editar(@RequestBody Pessoa pessoa, @PathVariable("id") long id){
        Pessoa p = service.listarId(id);
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

        final Pessoa updatedPessoa = service.edit(p);
        return ResponseEntity.ok(updatedPessoa);
    }
}
