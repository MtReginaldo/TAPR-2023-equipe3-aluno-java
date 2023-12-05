package br.edu.univille.microservmatricula.entity;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "Matricula")
public class Matricula {
    @Id
    @PartitionKey
    @GeneratedValue
    public String id;
    public String data;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getdata() {
        return data;
    }
    public void setdata(String data) {
        this.data = data;
    }

}


/*
    - id: long 
    - curso: String
    - nome: String
    - telefone:  long
    - data: String 
*/
