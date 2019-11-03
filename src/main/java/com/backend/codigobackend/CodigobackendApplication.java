package com.backend.codigobackend;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CodigobackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodigobackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(GlossarioRepository repository){
		repository.save(new Glossario("Algoritmo"));
		repository.save(new Glossario("Inteligência Artificial"));
		repository.save(new Glossario("Retropropagação" ));
		repository.save(new Glossario("Teorema de Bayes"));
		repository.save(new Glossario("Rede bayesiana"));
		repository.save(new Glossario("Viés"));
		repository.save(new Glossario("Big Data"));
		repository.save(new Glossario("Distribuição Binomial"));
		repository.save(new Glossario("Teste Qui-Quadrado"));
		repository.save(new Glossario("Classificação"));
		repository.save(new Glossario("Agrupamento"));
		repository.save(new Glossario("Coeficiente"));
		repository.save(new Glossario("Linguística Computacional"));
		repository.save(new Glossario("Intervalo de Confiança"));
		repository.save(new Glossario("Variável Contínua"));
		repository.save(new Glossario("Correlação"));
		repository.save(new Glossario("Covariância"));
		repository.save(new Glossario("Validação Cruzada"));
		repository.save(new Glossario("D3"));
		repository.save(new Glossario("Engenheiro de Dados"));
		repository.save(new Glossario("Mineração de Dados"));
		repository.save(new Glossario("Ciência de Dados"));
		repository.save(new Glossario("Estrutura de Dados"));
		repository.save(new Glossario("Disputa de Dados"));
		repository.save(new Glossario("Árvores de Decisão"));
		repository.save(new Glossario("Aprendizagem Profunda"));
		repository.save(new Glossario("Variável Dependente"));
		repository.save(new Glossario("Redução de Dimensão"));
		repository.save(new Glossario("Variável Discreta"));
		repository.save(new Glossario("Econometria"));
		repository.save(new Glossario("Característica"));
		repository.save(new Glossario("Engenharia de Recursos"));
		repository.save(new Glossario("PORTÃO"));
		repository.save(new Glossario("Aumento de Gradiente"));
		repository.save(new Glossario("Gradiente Descendente"));
		repository.save(new Glossario("Histograma"));
		repository.save(new Glossario("Variável Independente"));
		repository.save(new Glossario("Javascript"));
		repository.save(new Glossario("Cluster de K-significa"));
		repository.save(new Glossario("K Vizinhos mais Próximos"));
		repository.save(new Glossario("Variavel Latente"));
		repository.save(new Glossario("Lift"));
		repository.save(new Glossario("Álgebra Linear"));
		repository.save(new Glossario("Regressão Linear"));
		repository.save(new Glossario("Logaritmo"));
		repository.save(new Glossario("Regressão Logística"));
		repository.save(new Glossario("Aprendizado de Máquina"));
		repository.save(new Glossario("Modelo de Aprendizado de Máquina"));
		repository.save(new Glossario("Cadeia de Markov"));
		repository.save(new Glossario("MATLAB"));
		repository.save(new Glossario("Matriz"));
		repository.save(new Glossario("Significar"));
		repository.save(new Glossario("Erro Absoluto Médio"));
		repository.save(new Glossario("Erro Médio Quadrático"));
		repository.save(new Glossario("Mediana"));
		repository.save(new Glossario("Modo"));
		repository.save(new Glossario("Modelo"));
		repository.save(new Glossario("Método de Monte Carlo"));
		repository.save(new Glossario("Média Móvel"));
		repository.save(new Glossario("N-grama"));
		repository.save(new Glossario("Classificador Ingênuo de Bayes"));
		repository.save(new Glossario("Rede Neural"));
		repository.save(new Glossario("Distribuição Normal"));
		repository.save(new Glossario("NoSQL"));
		repository.save(new Glossario("Hipótese Nula"));
		repository.save(new Glossario("Função Objetiva"));
		repository.save(new Glossario("Overfitting"));
		repository.save(new Glossario("Valor P"));
		repository.save(new Glossario("Ranking da Página"));
		repository.save(new Glossario("Pandas"));
		repository.save(new Glossario("Perceptron"));
		repository.save(new Glossario("Perl"));
		repository.save(new Glossario("Tabela Dinâmica"));
		repository.save(new Glossario("Distribuição de Veneno"));
		repository.save(new Glossario("Distribuição Posterior"));
		repository.save(new Glossario("Análise Preditiva"));
		repository.save(new Glossario("Modelagem Preditiva"));
		repository.save(new Glossario("Análise do Componente Principal"));
		repository.save(new Glossario("Distribuição Prévia"));
		repository.save(new Glossario("Distribuição de Probabilidade"));
		repository.save(new Glossario("Pitão"));
		repository.save(new Glossario("Quantil, Quartil"));
		repository.save(new Glossario("R"));
		repository.save(new Glossario("Floresta Aleatória"));
		repository.save(new Glossario("RegressãO"));
		repository.save(new Glossario("Aprendizado por Reforço"));
		repository.save(new Glossario("Erro Médio Quadrático da Raiz"));
		repository.save(new Glossario("Rubi"));
		repository.save(new Glossario("Curva S"));
		repository.save(new Glossario("SAS"));
		repository.save(new Glossario("Escalar"));
		repository.save(new Glossario("Scripting"));
		repository.save(new Glossario("Concha"));
		repository.save(new Glossario("Dados Espaço-Temporais"));
		repository.save(new Glossario("SPSS"));
		repository.save(new Glossario("SQL"));
		repository.save(new Glossario("Desvio Padrão"));
		repository.save(new Glossario("Pontuação Padronizada"));
		repository.save(new Glossario("Stata"));
		repository.save(new Glossario("Estratos, Amostragem Estratificada"));
		repository.save(new Glossario("Aprendizado Supervisionado"));
		repository.save(new Glossario("Máquina de Vetor de Suporte"));
		repository.save(new Glossario("Distribuição T"));
		repository.save(new Glossario("Quadro"));
		repository.save(new Glossario("UIMA"));
		repository.save(new Glossario("Variação"));
		repository.save(new Glossario("Vetor"));
		repository.save(new Glossario("Espaço Vetorial"));
		repository.save(new Glossario("Weka"));
		return args -> {};
	}

}
