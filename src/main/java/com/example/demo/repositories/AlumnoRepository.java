package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Alumno;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long>{
    
}
