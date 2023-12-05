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
import br.edu.univille.microservmatricula.entity.matricula;
import br.edu.univille.microservmatricula.service.matriculaService;

@RestController
@RequestMapping("/api/v1/matriculas")
public class matriculaAPIController {

    @Autowired
    private matriculaService service;

    @GetMapping
    public ResponseEntity<List<matricula>> listamatriculas(){
        var listamatriculas = service.getAll();
        return 
            new ResponseEntity<List<matricula>>
            (listamatriculas, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<matricula> buscarmatricula(@PathVariable("id")  String id){
        var matricula = service.getById(id);
        if(matricula == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return 
            new ResponseEntity<matricula>
            (matricula, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<matricula> inserirmatricula(@RequestBody matricula matricula){
        if(matricula == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        matricula = service.saveNew(matricula);
        return 
            new ResponseEntity<matricula>
            (matricula, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<matricula> atualizarmatricula(@PathVariable("id")  String id, @RequestBody matricula matricula){
        if(matricula == null || id == ""  || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        matricula = service.update(id, matricula);
        if(matricula == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return 
            new ResponseEntity<matricula>
            (matricula, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<matricula> removermatricula(@PathVariable("id")  String id){
        if(id == ""  || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var matricula = service.delete(id);
        if(matricula == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return 
            new ResponseEntity<matricula>
            (matricula, HttpStatus.OK);
    }
}