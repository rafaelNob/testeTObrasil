package com.api.tobrasil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.tobrasil.model.Aluno;
import com.api.tobrasil.repository.AlunoRespository;

@SpringBootApplication
public class MicroservicosApplication implements CommandLineRunner{
	
	@Autowired
	private AlunoRespository rep;

	public static void main(String[] args) {
		SpringApplication.run(MicroservicosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			List<Aluno> lista = new ArrayList<Aluno>();
			Aluno aluno = new Aluno(null, "rafael Noberto", 35);
			Aluno aluno2 = new Aluno(null, "José da silva", 50);
			Aluno aluno3 = new Aluno(null, "Amanda santos", 20);
			Aluno aluno4 = new Aluno(null, "Carlos Henrique", 25);
			lista.addAll(Arrays.asList(aluno,aluno2,aluno3,aluno4));
			rep.saveAll(lista);
			
	}

}
