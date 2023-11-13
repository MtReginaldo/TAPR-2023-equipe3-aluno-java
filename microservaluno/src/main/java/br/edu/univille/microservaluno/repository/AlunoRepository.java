package br.edu.univille.microservaluno.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.univille.microservaluno.entity.Aluno;

@Repository
public interface AlunoRepository 
    extends CrudRepository<Aluno,String>{
    
}
