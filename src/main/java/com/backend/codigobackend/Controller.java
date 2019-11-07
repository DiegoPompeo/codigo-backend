package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/redesocial")
public class Controller {
    @Autowired
    private PessoaService service;

    @Autowired
    private PostService postService;

    @Autowired
    private PessoaRecomendadaService pessoaRecomendadaService;

    @Autowired
    private GlossarioService glossarioService;


    @GetMapping("")
    public List<Pessoa> lista() {
        return service.listar();
    }

    @PostMapping("/signup")
    public ResponseEntity<Pessoa> adiciona(@RequestBody @Valid Pessoa p) {
        return new ResponseEntity<>(service.add(p), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public Pessoa login(@RequestBody Pessoa p) {
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
    public boolean verifica(@PathVariable("email") String email) {
        List<Pessoa> lista = service.listar();
        for (Pessoa pessoa : lista) {
            if (pessoa.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @GetMapping("/buscar/{email}")
    public Pessoa busca(@PathVariable("email") String email) {
        List<Pessoa> lista = service.listar();
        for (Pessoa pessoa : lista) {
            if (pessoa.getEmail().equals(email)) {
                return pessoa;
            }
        }
        return null;
    }

    @GetMapping("/buscarCientista/{nome}")
    public List<Pessoa> buscaCientista(@PathVariable("nome") String nome) {
        return service.findNome(nome);
    }

    @GetMapping("/perfil/{id}")
    public Pessoa perfil(@PathVariable("id") int id) {
        return service.listarId(id);
    }

    @PutMapping("/editar/{email}")
    public ResponseEntity<Pessoa> editar(@RequestBody Pessoa pessoa, @PathVariable("email") String email) {
        List<Pessoa> lista = service.listar();
        for (Pessoa p : lista) {
            if (p.getEmail().equals(email)) {
                p.setEmail(pessoa.getEmail());
                p.setSenha(pessoa.getSenha());
                p.setPaga(pessoa.isPaga());
                p.setNroCartao(pessoa.getNroCartao());
                p.setNomeNoCartao(pessoa.getNomeNoCartao());
                p.setDataValidade(pessoa.getDataValidade());
                p.setNome(pessoa.getNome());
                p.setCodSeg(pessoa.getCodSeg());
                p.setEmpresa(pessoa.getEmpresa());
                p.setInicioDaAtividade(pessoa.getInicioDaAtividade());
                p.setDataNascimento(pessoa.getDataNascimento());
                p.setNivelEscolaridade(pessoa.getNivelEscolaridade());
                p.setCidade(pessoa.getCidade());
                p.setEstado(pessoa.getEstado());
                p.setInteresse(pessoa.getInteresse());
                return ResponseEntity.ok().body(service.edit(p));
            }
        }
        return  ResponseEntity.ok().body(pessoa);
    }

    @PostMapping("/addPost")
    public ResponseEntity<Post> addPost(@RequestBody @Valid Post post) {
        return new ResponseEntity<>(postService.add(post), HttpStatus.CREATED);
    }

    @GetMapping("/verPost/{email}")
    public List<Post> buscaPost(@PathVariable("email") String email) {
        List<Post> lista = postService.listar();
        List<Post> listaPostEmail = new ArrayList<>();
        for (Post post : lista) {
            if (post.getEmail().equals(email)) {
                listaPostEmail.add(post);
            }
        }
        return listaPostEmail;
    }

    @PostMapping("/addRecomendacao")
    public PessoaRecomendada addRecomendacao(@RequestBody PessoaRecomendada pessoaRecomendada) {
        return pessoaRecomendadaService.add(pessoaRecomendada);
    }

    @GetMapping("/getRecomendacao")
    public List<PessoaRecomendada> listRecomendacao() {
        return pessoaRecomendadaService.listar();
    }

    @GetMapping("/glossario")
    public List<Glossario> listaGlossario() {
        return glossarioService.listar();
    }

    @PostMapping("/addGlossario")
    public ResponseEntity<Glossario> addGlossario(@RequestBody Glossario glossario){
        return ResponseEntity.ok().body(glossarioService.add(glossario));
    }
}