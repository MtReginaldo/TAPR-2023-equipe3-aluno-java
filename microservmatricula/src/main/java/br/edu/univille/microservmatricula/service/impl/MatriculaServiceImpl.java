package br.edu.univille.microservmatricula.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.microservmatricula.entity.matricula;
import br.edu.univille.microservmatricula.repository.matriculaRepository;
import br.edu.univille.microservmatricula.service.matriculaService;

@Service
public class matriculaServiceImpl implements matriculaService{

    @Autowired
    private matriculaRepository repository;

    @Override
    public List<matricula> getAll() {
        var iterador = repository.findAll();
        List<matricula> listamatriculas = new ArrayList<>();

        iterador.forEach(listamatriculas::add);

        return listamatriculas;
    }

    @Override
    public matricula getById(String id) {
        var matricula = repository.findById(id);
        if(matricula.isPresent())
            return matricula.get();
        return null;
    }

    @Override
    public matricula saveNew(matricula matricula) {
        matricula.setId(null);
        return repository.save(matricula);
    }

    @Override
    public matricula update(String id, matricula matricula) {
        var buscamatriculaAntigo = repository.findById(id);
        if (buscamatriculaAntigo.isPresent()){
            var matriculaAntigo = buscamatriculaAntigo.get();

            //Atualizar cada atributo do objeto antigo 
            matriculaAntigo.setCpf(matricula.getCpf());
            
            return repository.save(matriculaAntigo);
        }
        return null;
    }

    @Override
    public matricula delete(String id) {
        var buscamatricula = repository.findById(id);
        if (buscamatricula.isPresent()){
            var matricula = buscamatricula.get();

            repository.delete(matricula);

            return matricula;
        }
        return null;
    }
}