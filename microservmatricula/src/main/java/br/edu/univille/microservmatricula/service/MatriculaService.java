package br.edu.univille.microservmatricula.service;
import java.util.List;
import br.edu.univille.microservmatricula.entity.Matricula;

public interface MatriculaService {
    public List<Matricula> getAll();
    public Matricula getById(String id);
    public Matricula saveNew(Matricula Matricula);
    public Matricula update(String id, Matricula Matricula);
    public Matricula delete(String id);
}