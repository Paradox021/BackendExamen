package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Alumno;
import com.example.demo.repositories.AlumnoRepository;

@Service
public class AlumnoService {
    
    @Autowired
    AlumnoRepository alumnoRepository;

    public Alumno saveAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    public ArrayList<Alumno> getAllAlumnos(){
        ArrayList<Alumno> alumnos = (ArrayList<Alumno>) alumnoRepository.findAll();
        return alumnos;
    }

    public void deleteAlumno(Long Id){
        alumnoRepository.deleteById(Id);
    }

}
