package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
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

    @PutMapping("/editar/{email}")
    public Pessoa editar(@Valid @RequestBody Pessoa pessoa, @PathVariable("email") String email){
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
                p.setSalario(pessoa.getSalario());
                return service.edit(p);
            }
        }
        return pessoa;
    }
    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post post){
        return postService.add(post);
    }

    @GetMapping("/verPost/{email}")
    public List<Post> buscaPost(@PathVariable("email") String email){
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
    public PessoaRecomendada addRecomendacao(@RequestBody PessoaRecomendada pessoaRecomendada){
        return pessoaRecomendadaService.add(pessoaRecomendada);
    }

    @GetMapping("/getRecomendacao")
    public List<PessoaRecomendada> listRecomendacao(){
        return pessoaRecomendadaService.listar();
    }
}
