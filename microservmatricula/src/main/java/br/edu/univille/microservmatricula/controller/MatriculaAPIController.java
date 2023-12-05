package br.edu.univille.microservmatricula.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.univille.microservmatricula.entity.Matricula;
import br.edu.univille.microservmatricula.service.MatriculaService;

@RestController
@RequestMapping("/api/v1/Matriculas")
public class MatriculaAPIController {

    @Autowired
    private MatriculaService service;

    @GetMapping
    public ResponseEntity<List<Matricula>> listaMatriculas(){
        var listaMatriculas = service.getAll();
        return 
            new ResponseEntity<List<Matricula>>
            (listaMatriculas, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Matricula> buscarMatricula(@PathVariable("id")  String id){
        var Matricula = service.getById(id);
        if(Matricula == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return 
            new ResponseEntity<Matricula>
            (Matricula, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Matricula> inserirMatricula(@RequestBody Matricula Matricula){
        if(Matricula == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Matricula = service.saveNew(Matricula);
        return 
            new ResponseEntity<Matricula>
            (Matricula, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Matricula> atualizarMatricula(@PathVariable("id")  String id, @RequestBody Matricula Matricula){
        if(Matricula == null || id == ""  || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Matricula = service.update(id, Matricula);
        if(Matricula == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return 
            new ResponseEntity<Matricula>
            (Matricula, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Matricula> removerMatricula(@PathVariable("id")  String id){
        if(id == ""  || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var Matricula = service.delete(id);
        if(Matricula == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return 
            new ResponseEntity<Matricula>
            (Matricula, HttpStatus.OK);
    }
}