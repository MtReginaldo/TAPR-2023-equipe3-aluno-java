package br.edu.univille.microservaluno.service;
import java.util.List;
import br.edu.univille.microservaluno.entity.Aluno;

public interface AlunoService {
    public List<Aluno> getAll();
    public Aluno getById(String id);
    public Aluno saveNew(Aluno aluno);
    public Aluno update(String id, Aluno aluno);
    public Aluno delete(String id);
}