package br.edu.univille.microservmatricula.service;
import java.util.List;
import br.edu.univille.microservmatricula.entity.matricula;

public interface matriculaService {
    public List<matricula> getAll();
    public matricula getById(String id);
    public matricula saveNew(matricula matricula);
    public matricula update(String id, matricula matricula);
    public matricula delete(String id);
}