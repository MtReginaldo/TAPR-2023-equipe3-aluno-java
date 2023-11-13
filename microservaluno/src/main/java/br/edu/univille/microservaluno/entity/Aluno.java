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
    public String cpf;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}


/*
    - id: long 
    - curso: String
    - nome: String
    - telefone:  long
    - cpf: String 
*/
