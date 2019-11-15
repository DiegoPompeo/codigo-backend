package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
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

    @Autowired
    private AmizadeService amizadeService;

    @CrossOrigin(origins = "*")
    @GetMapping("")
    public List<Pessoa> lista() {
        return service.listar();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/signup")
    public Pessoa adiciona(@Valid @RequestBody Pessoa p) {
        return service.add(p);
    }

    @CrossOrigin(origins = "*")
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

    @CrossOrigin(origins = "*")
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

    @CrossOrigin(origins = "*")
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

    @CrossOrigin(origins = "*")
    @GetMapping("/buscarCientista/{nome}")
    public List<Pessoa> buscaCientista(@PathVariable("nome") String nome) {
        return service.findNome(nome);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/perfil/{id}")
    public Pessoa perfil(@PathVariable("id") int id) {
        return service.listarId(id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/editar/{email}")
    public Pessoa editar(@Valid @RequestBody Pessoa pessoa, @PathVariable("email") String email) {
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
                p.setCurtida(pessoa.getCurtida());
                return service.edit(p);
            }
        }
        return pessoa;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/addPost")
    public Post addPost(@Valid @RequestBody Post post) {
        return postService.add(post);
    }

    @CrossOrigin(origins = "*")
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

    @CrossOrigin(origins = "*")
    @PostMapping("/addRecomendacao")
    public PessoaRecomendada addRecomendacao(@Valid @RequestBody PessoaRecomendada pessoaRecomendada) {
        return pessoaRecomendadaService.add(pessoaRecomendada);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getRecomendacao")
    public List<PessoaRecomendada> listRecomendacao() {
        return pessoaRecomendadaService.listar();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/glossario")
    public List<Glossario> listaGlossario() {
        return glossarioService.listar();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/addGlossario")
    public ResponseEntity<Glossario> addGlossario(@Valid @RequestBody Glossario glossario){
        return ResponseEntity.ok().body(glossarioService.add(glossario));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/amizade")
    public Amizade solicitaAmizade(@Valid @RequestBody Amizade amizade){
        return amizadeService.add(amizade);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/respostaSolicitacao/{email}")
    public Amizade respostaSolicitacao(@Valid @RequestBody Amizade amizade, @PathVariable("email") String email){
        List<Amizade> lista = amizadeService.listarAmizade();
        for (Amizade a: lista){
            if (a.getEmailMandatario().equals(email)){
                a.setAceite(amizade.isAceite());
                a.setEmailMandatario(amizade.getEmailMandatario());
                a.setEmailRemetente(amizade.getEmailRemetente());
                a.setRecusado(amizade.isRecusado());
                a.setSolicitado(false);
                return amizadeService.edit(a);
            }
        }
        return amizadeService.add(amizade);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/listaAmizade")
    public List<Amizade> listaAmizade(){
        return amizadeService.listarAmizade();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getAmizade/{email}")
    public List<Amizade> getAmizade(@PathVariable("email") String email){
        return amizadeService.listarEmail(email);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/recusar")
    public void recusaAmizade(@RequestBody Amizade amizade){
        amizadeService.delete(amizade);
    }

}