package com.backend.codigobackend;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class CodigobackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodigobackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(GlossarioRepository repository){
		ArrayList<String> lista = new ArrayList<>(
				Arrays.asList("Algoritmo", "AngularJS", "Inteligência Artificial", "Retropropagação" ,
						"Teorema de Bayes" , "Rede bayesiana", "Viés" ,"Big Data" , "Distribuição Binomial",
						"Teste Qui-Quadrado" ,"Classificação", "Agrupamento", "Coeficiente", "Linguística Computacional",
						"Intervalo de Confiança", "Variável Contínua" , "Correlação" ,"Covariância" , "Validação Cruzada",
						"D3", "Engenheiro de Dados" , "Mineração de Dados",  "Ciência de Dados" , "Estrutura de Dados",
						"Disputa de Dados", "Árvores de Decisão", "Aprendizagem Profunda",  "Variável Dependente",
						"Redução de Dimensão", "Variável Discreta", "Econometria" , "Característica", "Engenharia de Recursos",
						"PORTÃO", "Aumento de Gradiente", "Gradiente Descendente" , "Histograma" , "Variável Independente",
						"Javascript", "Cluster de K-significa", "K Vizinhos mais Próximos", "Variavel Latente", "Lift",
						"Álgebra Linear" , "Regressão Linear" , "Logaritmo", "Regressão Logística","Aprendizado de Máquina",
						"Modelo de Aprendizado de Máquina" , "Cadeia de Markov" , "MATLAB" , "Matriz","Significar",
						"Erro Absoluto Médio","Erro Médio Quadrático", "Mediana", "Modo", "Modelo", "Método de Monte Carlo",
						"Média Móvel", "N-grama", "Classificador Ingênuo de Bayes", "Rede Neural", "Distribuição Normal",
						"NoSQL", "Hipótese Nula" , "Função Objetiva", "Ponto Fora da Curva" ,"Overfitting", "Valor P",
						"Ranking da Página", "Pandas", "Perceptron", "Perl" , "Tabela Dinâmica" , "Distribuição de Veneno",
						"Distribuição Posterior", "Análise Preditiva", "Modelagem Preditiva", "Análise do Componente Principal",
						"Distribuição Prévia", "Distribuição de Probabilidade" ,"Pitão", "Quantil, Quartil" ,"R" , "Floresta Aleatória",
						"Regressão" , "Aprendizado por Reforço", "Erro Médio Quadrático da Raiz", "Rubi", "Curva S", "SAS", "Escalar",
						"Scripting", "Correlação Serial", "Concha", "Dados Espaço-Temporais","SPSS" , "SQL", "Desvio Padrão",
						"Distribuição Normal Padrão", "Pontuação Padronizada", "Stata" , "Estratos, Amostragem Estratificada",
						"Aprendizado Supervisionado", "Máquina de Vetor de Suporte" , "Distribuição T", "Quadro",
						"Dados de Séries Temporais", "UIMA" , "Aprendizado não Supervisionado", "Variação", "Vetor", "Espaço Vetorial",
						"Weka")
		);
		if(repository.findAll().isEmpty()){
				lista.forEach(nome -> {
					Glossario glossario = new Glossario();
					glossario.setNome(nome);
					repository.save(glossario);
				});
		}
		return args -> {};
	}

}
