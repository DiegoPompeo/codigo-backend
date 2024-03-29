package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@CrossOrigin("*")
@RestController
@RequestMapping("/redesocial")
class Controller {
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

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CurtirPostService curtirPostService;

    @GetMapping("")
    public List<Pessoa> lista() {
        return pessoaRepository.findAll();
    }

    @PostMapping("/signup")
    public Pessoa adiciona(@Valid @RequestBody Pessoa p) {
        return pessoaRepository.save(p);
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
                p.setCurtir(pessoa.getCurtir());
                return service.edit(p);
            }
        }
        return pessoa;
    }

    @PostMapping("/addPost")
    public Post addPost(@Valid @RequestBody Post post) {
        Random r = new Random();
        int cont = 0;
        StringBuilder codPost = new StringBuilder("abc");
        String[] alfabeto= {"a","b","c","d","e","f","g","h","i","j"};

        while(cont < 5){
            cont++;
            codPost.append(alfabeto[r.nextInt(9)]);
        }

        post.setCodPost(codPost.toString());
        return postService.add(post);
    }

    @PutMapping("/atualizaPost/{codPost}")
    public Post atualizaPost(@Valid @RequestBody Post post,
                             @PathVariable("codPost") String codPost){
        List<Post> lista = postService.listar();
        for (Post p : lista) {
            if (p.getCodPost().equals(codPost)) {
                p.setCurtidas(post.getCurtidas());
                p.setConteudo(post.getConteudo());
                return postService.edit(p);
            }
        }
        return postService.add(post);
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

    @PostMapping("/curtir")
    public CurtirPost curtir(@Valid @RequestBody CurtirPost curtirPost){
        curtirPost.setCurtiu(true);
        return curtirPostService.save(curtirPost);
    }

    @GetMapping("/listaCurtida")
    public List<CurtirPost> listaCurtida(){
        return curtirPostService.findAll();
    }

    @GetMapping("/verificaCurtida/{codPost}")
    public boolean verificaCurtida(@PathVariable("codPost") String idPost){
        List<CurtirPost> lista = curtirPostService.findAll();
        for (CurtirPost curtirPost : lista) {
            if (curtirPost.getIdPost().equals(idPost)) {
                return true;
            }
        }
        return false;
    }

    @DeleteMapping("/descurtir/{codPost}")
    public void descurtir(@PathVariable("codPost") String idPost){
        List<CurtirPost> lista = curtirPostService.findAll();
        for (CurtirPost curtirPost: lista) {
            if (curtirPost.getIdPost().equals(idPost)){
                curtirPostService.delete(curtirPost);
            }
        }
    }

    @PostMapping("/addRecomendacao")
    public PessoaRecomendada addRecomendacao(@Valid @RequestBody PessoaRecomendada pessoaRecomendada) {
        return pessoaRecomendadaService.add(pessoaRecomendada);
    }

    @GetMapping("/getRecomendacao")
    public List<PessoaRecomendada> listRecomendacao() {
        return pessoaRecomendadaService.listar();
    }

    @PutMapping("/recomendou/{emailRecomendou}/{emailRecomendada}")
    public PessoaRecomendada recomendou(@Valid @RequestBody PessoaRecomendada pessoaRecomendada,
                                              @PathVariable("emailRecomendou") String emailRecomendou,
                                              @PathVariable("emailRecomendada") String emailRecomendada){
        List<PessoaRecomendada> lista = pessoaRecomendadaService.listar();
        for (PessoaRecomendada p : lista) {
            if (p.getEmailRecomendou().equals(emailRecomendou) && p.getEmailRecomendada().equals(emailRecomendada)){
                    p.setEmailRecomendada(pessoaRecomendada.getEmailRecomendada());
                    p.setEmailRecomendou(pessoaRecomendada.getEmailRecomendou());
                    p.setDesfazer(false);
                    return pessoaRecomendadaService.edit(p);
            }
        }
        return pessoaRecomendadaService.add(pessoaRecomendada);
    }

    @PutMapping("/desrecomendou/{emailRecomendou}/{emailRecomendada}")
    public PessoaRecomendada desrecomendou(@Valid @RequestBody PessoaRecomendada pessoaRecomendada,
                                        @PathVariable("emailRecomendou") String emailRecomendou,
                                        @PathVariable("emailRecomendada") String emailRecomendada){
        List<PessoaRecomendada> lista = pessoaRecomendadaService.listar();
        for (PessoaRecomendada p : lista) {
            if (p.getEmailRecomendou().equals(emailRecomendou) && p.getEmailRecomendada().equals(emailRecomendada)){
                p.setEmailRecomendada(pessoaRecomendada.getEmailRecomendada());
                p.setEmailRecomendou(pessoaRecomendada.getEmailRecomendou());
                p.setDesfazer(true);
                return pessoaRecomendadaService.edit(p);
            }
        }
        return pessoaRecomendadaService.add(pessoaRecomendada);
    }

    @GetMapping("/glossario")
    public List<Glossario> listaGlossario() {
        return glossarioService.listar();
    }

    @PostMapping("/addGlossario")
    public ResponseEntity<Glossario> addGlossario(@Valid @RequestBody Glossario glossario){
        return ResponseEntity.ok().body(glossarioService.add(glossario));
    }

    @PostMapping("/amizade")
    public Amizade solicitaAmizade(@Valid @RequestBody Amizade amizade){
        return amizadeService.add(amizade);
    }

    @PutMapping("/respostaSolicitacao/{emailMandatario}/{emailRemetente}")
    public Amizade respostaSolicitacao(@Valid @RequestBody Amizade amizade,
                                       @PathVariable("emailMandatario") String emailMandatario,
                                       @PathVariable("emailRemetente") String emailRemetente){
        List<Amizade> lista = amizadeService.listarAmizade();
        for (Amizade a: lista){
            if (a.getEmailMandatario().equals(emailMandatario) && a.getEmailRemetente().equals(emailRemetente)){
                a.setEmailMandatario(amizade.getEmailMandatario());
                a.setEmailRemetente(amizade.getEmailRemetente());
                a.setRecusado(false);
                a.setSolicitado(false);
                a.setAceite(true);
                return amizadeService.edit(a);
            }
        }
        return amizadeService.add(amizade);
    }
    @PutMapping("/recusaSolicitacao/{emailMandatario}/{emailRemetente}")
    public Amizade recusaSolicitacao(@Valid @RequestBody Amizade amizade,
                                       @PathVariable("emailMandatario") String emailMandatario,
                                       @PathVariable("emailRemetente") String emailRemetente){
        List<Amizade> lista = amizadeService.listarAmizade();
        for (Amizade a: lista){
            if (a.getEmailMandatario().equals(emailMandatario) && a.getEmailRemetente().equals(emailRemetente)){
                a.setEmailMandatario(amizade.getEmailMandatario());
                a.setEmailRemetente(amizade.getEmailRemetente());
                a.setRecusado(true);
                a.setSolicitado(false);
                a.setAceite(false);
                return amizadeService.edit(a);
            }
        }
        return amizadeService.add(amizade);
    }

    @GetMapping("/listaAmizade")
    public List<Amizade> listaAmizade(){
        return amizadeService.listarAmizade();
    }

    @GetMapping("/getAmizade/{email}")
    public List<Amizade> getAmizade(@PathVariable("email") String email){
        return amizadeService.listarEmail(email);
    }

    @DeleteMapping("/recusar")
    public void recusaAmizade(@RequestBody Amizade amizade){
        amizadeService.delete(amizade);
    }
}