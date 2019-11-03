package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@SpringBootApplication
public class CodigobackendApplication  implements CommandLineRunner {

	@Autowired
	private GlossarioRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CodigobackendApplication.class, args);
	}

	@Override
	public void run(String... args) {
		repository.deleteAll();
		Glossario g = new Glossario();
		g.setNome("Algoritmo");

		repository.save(g);
		g = new Glossario();
		g.setNome("AngularJS");

		repository.save(g);
		g = new Glossario();
		g.setNome("Inteligência Artificial");

		repository.save(g);
		g = new Glossario();
		g.setNome("Retropropagação");

		repository.save(g);
		g = new Glossario();
		g.setNome("Inteligência Artificial");
		repository.save(g);

		g = new Glossario();
		g.setNome("Teorema de Bayes");
		repository.save(g);

		g = new Glossario();
		g.setNome("Rede bayesiana");
		repository.save(g);

		g = new Glossario();
		g.setNome("Viés");
		repository.save(g);

		g = new Glossario();
		g.setNome("Big Data");
		repository.save(g);

		g = new Glossario();
		g.setNome("Distribuição Binomial");
		repository.save(g);

		g = new Glossario();
		g.setNome("Teste Qui-Quadrado");
		repository.save(g);

		g = new Glossario();
		g.setNome("Classificação");
		repository.save(g);

		g = new Glossario();
		g.setNome("Agrupamento");
		repository.save(g);

		g = new Glossario();
		g.setNome("Coeficiente");
		repository.save(g);

		g = new Glossario();
		g.setNome("Linguística Computacional");
		repository.save(g);

		g = new Glossario();
		g.setNome("Intervalo de Confiança");
		repository.save(g);

		g = new Glossario();
		g.setNome("Variável Contínua");
		repository.save(g);

		repository.save(g);
		g = new Glossario();
		g.setNome("Correlação");

		repository.save(g);
		g = new Glossario();
		g.setNome("Covariância");

		repository.save(g);
		g = new Glossario();
		g.setNome("Validação Cruzada");

		repository.save(g);
		g = new Glossario();
		g.setNome("D3");
		repository.save(g);

		g = new Glossario();
		g.setNome("Engenheiro de Dados");
		repository.save(g);

		g = new Glossario();
		g.setNome("Mineração de Dados");
		repository.save(g);

		g = new Glossario();
		g.setNome("Ciência de Dados");
		repository.save(g);

		g = new Glossario();
		g.setNome("Estrutura de Dados");
		repository.save(g);

		g = new Glossario();
		g.setNome("Disputa de Dados");
		repository.save(g);

		g = new Glossario();
		g.setNome("Árvores de Decisão");
		repository.save(g);

		g = new Glossario();
		g.setNome("Aprendizagem Profunda");
		repository.save(g);

		g = new Glossario();
		g.setNome("Variável Dependente");
		repository.save(g);

		g = new Glossario();
		g.setNome("Redução de Dimensão");
		repository.save(g);

		g = new Glossario();
		g.setNome("Variável Discreta");
		repository.save(g);

		g = new Glossario();
		g.setNome("Econometria");
		repository.save(g);

		g = new Glossario();
		g.setNome("Característica");
		repository.save(g);

		g = new Glossario();
		g.setNome("Engenharia de Recursos");
		repository.save(g);

		g = new Glossario();
		g.setNome("PORTÃO");
		repository.save(g);

		g = new Glossario();
		g.setNome("Aumento de Gradiente");
		repository.save(g);

		g = new Glossario();
		g.setNome("Gradiente Descendente");
		repository.save(g);

		g = new Glossario();
		g.setNome("Histograma");
		repository.save(g);

		g = new Glossario();
		g.setNome("Variável Independente");
		repository.save(g);

		g = new Glossario();
		g.setNome("Javascript");
		repository.save(g);

		g = new Glossario();
		g.setNome("Cluster de K-significa");
		repository.save(g);

		g = new Glossario();
		g.setNome("K Vizinhos mais Próximos");
		repository.save(g);

		g = new Glossario();
		g.setNome("Variavel Latente");
		repository.save(g);

		g = new Glossario();
		g.setNome("Lift");
		repository.save(g);

		g = new Glossario();
		g.setNome("Álgebra Linear");
		repository.save(g);

		g = new Glossario();
		g.setNome("Regressão Linear");
		repository.save(g);

		g = new Glossario();
		g.setNome("Logaritmo");
		repository.save(g);

		g = new Glossario();
		g.setNome("Regressão Logística");
		repository.save(g);

		g = new Glossario();
		g.setNome("Aprendizado de Máquina");
		repository.save(g);

		g = new Glossario();
		g.setNome("Modelo de Aprendizado de Máquina");
		repository.save(g);

		g = new Glossario();
		g.setNome("Cadeia de Markov");
		repository.save(g);

		g = new Glossario();
		g.setNome("MATLAB");
		repository.save(g);

		g = new Glossario();
		g.setNome("Matriz");
		repository.save(g);

		g = new Glossario();
		g.setNome("Significar");
		repository.save(g);

		g = new Glossario();
		g.setNome("Erro Absoluto Médio");
		repository.save(g);

		g = new Glossario();
		g.setNome("Erro Médio Quadrático");
		repository.save(g);

		g = new Glossario();
		g.setNome("Mediana");
		repository.save(g);

		g = new Glossario();
		g.setNome("Modo");
		repository.save(g);

		g = new Glossario();
		g.setNome("Modelo");
		repository.save(g);

		g = new Glossario();
		g.setNome("Método de Monte Carlo");
		repository.save(g);

		g = new Glossario();
		g.setNome("Média Móvel");
		repository.save(g);

		g = new Glossario();
		g.setNome("N-grama");
		repository.save(g);

		g = new Glossario();
		g.setNome("Classificador Ingênuo de Bayes");
		repository.save(g);

		g = new Glossario();
		g.setNome("Rede Neural");
		repository.save(g);

		g = new Glossario();
		g.setNome("Distribuição Normal");
		repository.save(g);

		repository.save(g);
		g = new Glossario();
		g.setNome("NoSQL");

		repository.save(g);
		g = new Glossario();
		g.setNome("Hipótese Nula");

		repository.save(g);
		g = new Glossario();
		g.setNome("Função Objetiva");

		repository.save(g);
		g = new Glossario();
		g.setNome("Ponto Fora da Curva");

		g = new Glossario();
		g.setNome("Overfitting");
		repository.save(g);

		g = new Glossario();
		g.setNome("Valor P");
		repository.save(g);

		g = new Glossario();
		g.setNome("Ranking da Página");
		repository.save(g);

		g = new Glossario();
		g.setNome("Pandas");
		repository.save(g);

		g = new Glossario();
		g.setNome("Perceptron");
		repository.save(g);

		g = new Glossario();
		g.setNome("Perl");
		repository.save(g);

		g = new Glossario();
		g.setNome("Tabela Dinâmica");
		repository.save(g);

		g = new Glossario();
		g.setNome("Distribuição de Veneno");
		repository.save(g);

		g = new Glossario();
		g.setNome("Distribuição Posterior");
		repository.save(g);

		g = new Glossario();
		g.setNome("Análise Preditiva");
		repository.save(g);

		g = new Glossario();
		g.setNome("Modelagem Preditiva");
		repository.save(g);

		g = new Glossario();
		g.setNome("Análise do Componente Principal");
		repository.save(g);

		g = new Glossario();
		g.setNome("Distribuição Prévia");
		repository.save(g);

		g = new Glossario();
		g.setNome("Distribuição de Probabilidade");
		repository.save(g);

		g = new Glossario();
		g.setNome("Pitão");
		repository.save(g);

		g = new Glossario();
		g.setNome("Quantil, Quartil");
		repository.save(g);

		g = new Glossario();
		g.setNome("R");
		repository.save(g);

		g = new Glossario();
		g.setNome("Floresta Aleatória");
		repository.save(g);

		g = new Glossario();
		g.setNome("Regressão");
		repository.save(g);

		g = new Glossario();
		g.setNome("Aprendizado por Reforço");
		repository.save(g);

		g = new Glossario();
		g.setNome("Erro Médio Quadrático da Raiz");
		repository.save(g);

		g = new Glossario();
		g.setNome("Rubi");
		repository.save(g);

		g = new Glossario();
		g.setNome("Curva S");
		repository.save(g);

		g = new Glossario();
		g.setNome("SAS");
		repository.save(g);

		g = new Glossario();
		g.setNome("Escalar");
		repository.save(g);

		g = new Glossario();
		g.setNome("Scripting");
		repository.save(g);

		g = new Glossario();
		g.setNome("Correlação Serial");
		repository.save(g);

		g = new Glossario();
		g.setNome("Concha");
		repository.save(g);

		g = new Glossario();
		g.setNome("Dados Espaço-Temporais");
		repository.save(g);

		g = new Glossario();
		g.setNome("SPSS");
		repository.save(g);

		g = new Glossario();
		g.setNome("SQL");
		repository.save(g);

		g = new Glossario();
		g.setNome("Desvio Padrão");
		repository.save(g);

		g = new Glossario();
		g.setNome("Distribuição Normal Padrão");
		repository.save(g);

		g = new Glossario();
		g.setNome("Pontuação Padronizada");
		repository.save(g);

		g = new Glossario();
		g.setNome("Stata");
		repository.save(g);

		g = new Glossario();
		g.setNome("Estratos, Amostragem Estratificada");
		repository.save(g);

		g = new Glossario();
		g.setNome("Aprendizado Supervisionado");
		repository.save(g);

		g = new Glossario();
		g.setNome("Máquina de Vetor de Suporte");
		repository.save(g);

		g = new Glossario();
		g.setNome("Distribuição T");
		repository.save(g);

		g = new Glossario();
		g.setNome("Quadro");
		repository.save(g);

		g = new Glossario();
		g.setNome("Dados de Séries Temporais");
		repository.save(g);

		g = new Glossario();
		g.setNome("UIMA");
		repository.save(g);

		g = new Glossario();
		g.setNome("Aprendizado não Supervisionado");
		repository.save(g);

		g = new Glossario();
		g.setNome("VariaçãO");
		repository.save(g);

		g = new Glossario();
		g.setNome("Vetor");
		repository.save(g);

		g = new Glossario();
		g.setNome("Espaço Vetorial");
		repository.save(g);

		g = new Glossario();
		g.setNome("Weka");
		repository.save(g);
	}
}
