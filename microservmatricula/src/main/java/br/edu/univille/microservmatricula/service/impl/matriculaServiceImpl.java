package br.edu.univille.microservmatricula.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.microservmatricula.entity.Matricula;
import br.edu.univille.microservmatricula.repository.MatriculaRepository;
import br.edu.univille.microservmatricula.service.MatriculaService;

@Service
public class matriculaServiceImpl implements MatriculaService{

    @Autowired
    private MatriculaRepository repository;

    @Override
    public List<Matricula> getAll() {
        var iterador = repository.findAll();
        List<Matricula> listaMatriculas = new ArrayList<>();

        iterador.forEach(listaMatriculas::add);

        return listaMatriculas;
    }

    @Override
    public Matricula getById(String id) {
        var Matricula = repository.findById(id);
        if(Matricula.isPresent())
            return Matricula.get();
        return null;
    }

    @Override
    public Matricula saveNew(Matricula Matricula) {
        Matricula.setId(null);
        return repository.save(Matricula);
    }

    @Override
    public Matricula update(String id, Matricula Matricula) {
        var buscaMatriculaAntigo = repository.findById(id);
        if (buscaMatriculaAntigo.isPresent()){
            var MatriculaAntigo = buscaMatriculaAntigo.get();

            //Atualizar cada atributo do objeto antigo 
            MatriculaAntigo.setdata(Matricula.getdata());
            
            return repository.save(MatriculaAntigo);
        }
        return null;
    }

    @Override
    public Matricula delete(String id) {
        var buscaMatricula = repository.findById(id);
        if (buscaMatricula.isPresent()){
            var Matricula = buscaMatricula.get();

            repository.delete(Matricula);

            return Matricula;
        }
        return null;
    }
}