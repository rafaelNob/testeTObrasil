package com.api.tobrasil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tobrasil.exception.ObjectNotFoundException;
import com.api.tobrasil.model.Aluno;
import com.api.tobrasil.repository.AlunoRespository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRespository alunoRepository;

	public List<Aluno> findAll() {

		return alunoRepository.findAll();
	}

	public Aluno findById(Integer id) {

		return alunoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Aluno não encontrado"));

	}

	public Aluno saveAluno(Aluno aluno) {

		return alunoRepository.save(aluno);

	}

	public Aluno updateAluno(Aluno aluno) {

		Aluno newObj = findById(aluno.getId());
		updateData(newObj, aluno);
		return alunoRepository.save(newObj);

	}
	
	public void deleteAluno(Integer id) {
		Aluno newObj = findById(id);
		alunoRepository.delete(newObj);

	}
	

	private void updateData(Aluno newObj, Aluno obj) {
		newObj.setNome(obj.getNome());
		newObj.setIdade(obj.getIdade());
	}

}
