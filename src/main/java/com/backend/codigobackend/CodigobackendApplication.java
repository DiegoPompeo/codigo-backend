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
		Glossario g = new Glossario();
		g.setNome("Inteligência Artificial");
		repository.save(g);
	}
}
