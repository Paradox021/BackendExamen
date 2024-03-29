package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    int nota;

    public Long getId(){
        return id;
    } 

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setNota(int nota){
        this.nota = nota;
    }
    public int getNota(){
        return nota;
    }
}
