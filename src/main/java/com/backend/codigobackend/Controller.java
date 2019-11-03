package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Pessoa adiciona(@Valid @RequestBody Pessoa p) {
        return service.add(p);
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

    @GetMapping("/buscarCientista/{email}")
    public List<Pessoa> buscaCientista(@PathVariable("email") String email) {
        return service.findNome(email);
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
                return service.edit(p);
            }
        }
        return pessoa;
    }

    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post post) {
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
    public void addGlossario(){

        ArrayList<String> lista = new ArrayList<>(
                Arrays.asList(
                        "AngularJS", "Inteligência Artificial", "Retropropagação",
                        "Teorema de Bayes", "Rede bayesiana", "Viés", "Big Data", "Distribuição Binomial",
                        "Teste Qui-Quadrado", "Classificação", "Agrupamento", "Coeficiente", "Linguística Computacional",
                        "Intervalo de Confiança", "Variável Contínua", "Correlação", "Covariância", "Validação Cruzada",
                        "D3", "Engenheiro de Dados", "Mineração de Dados", "Ciência de Dados", "Estrutura de Dados",
                        "Disputa de Dados", "Árvores de Decisão", "Aprendizagem Profunda", "Variável Dependente",
                        "Redução de Dimensão", "Variável Discreta", "Econometria", "Característica", "Engenharia de Recursos",
                        "PORTÃO", "Aumento de Gradiente", "Gradiente Descendente", "Histograma", "Variável Independente",
                        "Javascript", "Cluster de K-significa", "K Vizinhos mais Próximos", "Variavel Latente", "Lift",
                        "Álgebra Linear", "Regressão Linear", "Logaritmo", "Regressão Logística", "Aprendizado de Máquina",
                        "Modelo de Aprendizado de Máquina", "Cadeia de Markov", "MATLAB", "Matriz", "Significar",
                        "Erro Absoluto Médio", "Erro Médio Quadrático", "Mediana", "Modo", "Modelo", "Método de Monte Carlo",
                        "Média Móvel", "N-grama", "Classificador Ingênuo de Bayes", "Rede Neural", "Distribuição Normal",
                        "NoSQL", "Hipótese Nula", "Função Objetiva", "Ponto Fora da Curva", "Overfitting", "Valor P",
                        "Ranking da Página", "Pandas", "Perceptron", "Perl", "Tabela Dinâmica", "Distribuição de Veneno",
                        "Distribuição Posterior", "Análise Preditiva", "Modelagem Preditiva", "Análise do Componente Principal",
                        "Distribuição Prévia", "Distribuição de Probabilidade", "Pitão", "Quantil, Quartil", "R", "Floresta Aleatória",
                        "Regressão", "Aprendizado por Reforço", "Erro Médio Quadrático da Raiz", "Rubi", "Curva S", "SAS", "Escalar",
                        "Scripting", "Correlação Serial", "Concha", "Dados Espaço-Temporais", "SPSS", "SQL", "Desvio Padrão",
                        "Distribuição Normal Padrão", "Pontuação Padronizada", "Stata", "Estratos, Amostragem Estratificada",
                        "Aprendizado Supervisionado", "Máquina de Vetor de Suporte", "Distribuição T", "Quadro",
                        "Dados de Séries Temporais", "UIMA", "Aprendizado não Supervisionado", "Variação", "Vetor", "Espaço Vetorial",
                        "Weka"
                )
        );
        lista.forEach(data -> {
            Glossario g = new Glossario();
            g.setNome(data);
            glossarioService.add(g);
        });
    }
}