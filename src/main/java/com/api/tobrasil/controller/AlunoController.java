package com.api.tobrasil.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.tobrasil.model.Aluno;
import com.api.tobrasil.service.AlunoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Api REST ALUNO")
@CrossOrigin(origins = "*")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de Aluno")
	public ResponseEntity<List<Aluno>> findAll() {

		return ResponseEntity.ok().body(alunoService.findAll());
	}

	@GetMapping("/find/{id}")
	@ApiOperation(value = "Retorna uma Aluno")
	public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
		Aluno findById = alunoService.findById(id);
		return ResponseEntity.ok().body(findById);
	}

	@PostMapping("/save")
	@ApiOperation(value = "insere um Aluno")
	public ResponseEntity<Aluno> saveAluno(@Valid @RequestBody Aluno aluno) {

		alunoService.saveAluno(aluno);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/alter")
	@ApiOperation(value = "Altera um Aluno")
	public ResponseEntity<Void> updateAluno(@Valid @RequestBody Aluno aluno) {

		alunoService.updateAluno(aluno);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "deleta um Aluno")
	public ResponseEntity<Void> deleteAluno(@PathVariable Integer id) {

		alunoService.deleteAluno(id);
		return ResponseEntity.noContent().build();
	}

}
