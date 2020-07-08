package com.api.tobrasil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.tobrasil.model.Aluno;


@Repository
public interface AlunoRespository extends JpaRepository<Aluno, Integer> {

}
