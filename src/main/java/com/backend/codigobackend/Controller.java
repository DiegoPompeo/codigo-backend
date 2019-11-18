package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
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
                return service.edit(p);
            }
        }
        return pessoa;
    }

    @PostMapping("/addPost")
    public Post addPost(@Valid @RequestBody Post post) {
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

    @PostMapping("/addRecomendacao")
    public PessoaRecomendada addRecomendacao(@Valid @RequestBody PessoaRecomendada pessoaRecomendada) {
        return pessoaRecomendadaService.add(pessoaRecomendada);
    }

    @GetMapping("/getRecomendacao")
    public List<PessoaRecomendada> listRecomendacao() {
        return pessoaRecomendadaService.listar();
    }

    @PutMapping("/editRecomendacao/{emailRecomendou}/{emailRecomendada}")
    public PessoaRecomendada editRecomendacao(@Valid @RequestBody PessoaRecomendada pessoaRecomendada,
                                              @PathVariable("emailRecomendou") String emailRecomendou,
                                              @PathVariable("emailRecomendada") String emailRecomendada){
        List<PessoaRecomendada> lista = pessoaRecomendadaService.listar();
        for (PessoaRecomendada p : lista) {
            if (p.getEmailRecomendou().equals(emailRecomendou) && p.getEmailRecomendada().equals(emailRecomendada)){
                    p.setEmailRecomendada(pessoaRecomendada.getEmailRecomendada());
                    p.setEmailRecomendou(pessoaRecomendada.getEmailRecomendou());
                    p.setDesfazer(pessoaRecomendada.isDesfazer());
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
                a.setAceite(amizade.isAceite());
                a.setEmailMandatario(amizade.getEmailMandatario());
                a.setEmailRemetente(amizade.getEmailRemetente());
                a.setRecusado(amizade.isRecusado());
                a.setSolicitado(amizade.isSolicitado());
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

    @PostMapping("/postagemCurtida")
    public CurtirPost postagemCurtida(@Valid @RequestBody CurtirPost curtirPost){
        return curtirPostService.save(curtirPost);
    }

    @PutMapping("/atualizaCurtida/{idPost}")
    public CurtirPost atualizaCurtida(@Valid @RequestBody CurtirPost curtirPost, @PathVariable("idPost") String idPost){
        List<CurtirPost> lista = curtirPostService.findAll();
        for (CurtirPost c: lista){
            if (c.getIdPost().equals(idPost)){
                c.setDescurtiu(curtirPost.isDescurtiu());
                c.setEmailCurtido(curtirPost.getEmailCurtido());
                c.setEmailCurtiu(curtirPost.getEmailCurtiu());
                c.setIdPost(curtirPost.getIdPost());
                return curtirPostService.edit(c);
            }
        }
        return curtirPostService.save(curtirPost);
    }

    @GetMapping("/listaCurtidaPost")
    public List<CurtirPost> listaCurtidaPost(){
        return curtirPostService.findAll();
    }

    @GetMapping("/getIdPost/{idPost}")
    public CurtirPost getIdPost(@PathVariable("idPost") String idPost){
        return curtirPostService.findByIdPost(idPost);
    }

    @GetMapping("/getCurtido/{emailCurtido}")
    public CurtirPost getCurtido(@PathVariable("emailCurtido") String emailCurtido){
        return curtirPostService.findByEmailCurtido(emailCurtido);
    }

    @GetMapping("/getCurtiu/{emailCurtiu}")
    public CurtirPost getCurtiu(@PathVariable("emailCurtiu") String emailCurtiu){
        return curtirPostService.findByEmailCurtiu(emailCurtiu);
    }
}