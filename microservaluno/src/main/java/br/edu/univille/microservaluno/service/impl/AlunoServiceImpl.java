package br.edu.univille.microservaluno.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.microservaluno.entity.Aluno;
import br.edu.univille.microservaluno.repository.AlunoRepository;
import br.edu.univille.microservaluno.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService{

    @Autowired
    private AlunoRepository repository;

    @Override
    public List<Aluno> getAll() {
        var iterador = repository.findAll();
        List<Aluno> listaAlunos = new ArrayList<>();

        iterador.forEach(listaAlunos::add);

        return listaAlunos;
    }

    @Override
    public Aluno getById(String id) {
        var aluno = repository.findById(id);
        if(aluno.isPresent())
            return aluno.get();
        return null;
    }

    @Override
    public Aluno saveNew(Aluno aluno) {
        aluno.setId(null);
        return repository.save(aluno);
    }

    @Override
    public Aluno update(String id, Aluno aluno) {
        var buscaAlunoAntigo = repository.findById(id);
        if (buscaAlunoAntigo.isPresent()){
            var alunoAntigo = buscaAlunoAntigo.get();

            //Atualizar cada atributo do objeto antigo 
            alunoAntigo.setCpf(aluno.getCpf());
            
            return repository.save(alunoAntigo);
        }
        return null;
    }

    @Override
    public Aluno delete(String id) {
        var buscaAluno = repository.findById(id);
        if (buscaAluno.isPresent()){
            var aluno = buscaAluno.get();

            repository.delete(aluno);

            return aluno;
        }
        return null;
    }
}