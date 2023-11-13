package br.edu.univille.microservaluno.entity;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "aluno")
public class Aluno {
    @Id
    @GeneratedValue
    public String id;
    @PartitionKey
    public String nome;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}


/*
    - id: long 
    - curso: String
    - nome: String
    - telefone:  long
    - cpf: String 
*/
