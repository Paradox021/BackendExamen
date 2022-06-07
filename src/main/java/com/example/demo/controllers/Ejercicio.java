package com.example.demo.controllers;
import java.text.MessageFormat;
import java.util.ArrayList;

import com.example.demo.models.Alumno;
import com.example.demo.models.InfoHabitantes;
import com.example.demo.services.AlumnoService;
import com.example.demo.services.PopulationService;
import com.example.demo.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ejercicio {


    @Autowired
    AlumnoService alumnoService;


    @Autowired
    PopulationService populationService;
    
    // http://localhost:8080/
    @GetMapping("/")
    public String greet(){
        return "Bienvenido al servidor backend<br/>"+
        "<br/>/letradni/XXXX  para calcular leta del dni<br/>"+
        "<br/>/coincidencias?nombre1=XXXX&nombre2=XXXX  para contar letras coincidentes de dos palabras<br/>"+
        "<br/>/habitantes/XXXX  para ver los habitantes de un pais/ciudad"+
        "<br/>/guarda?nombre=XXXX&nota=XXXX  para registrar un alumno en la bbdd<br/>"+
        "<br/>/listar para  listar los alumnos registrados en la bbdd<br/>";
    }
    
    // http://localhost:8080/letraDni/????
    @GetMapping("/letradni/{texto}")
    public String devuelveLetraDni(@PathVariable String texto){
        String letraDni = Utils.validaLetra(texto); 
        texto = MessageFormat.format("A {0} le corresponde la letra: {1}" , texto, letraDni);
        return texto;
    }

    // http://localhost:8080/letraDni/????
    @GetMapping("/coincidencias")
    public String calculaCoincidencias(@RequestParam String nombre1, @RequestParam String nombre2){
        int coincidencias = Utils.calculaCoincidencias(nombre1, nombre2); 
        String texto = MessageFormat.format("{0} y {1} tienen {2} letras en comun" , nombre1, nombre2, coincidencias);
        return texto;
    }

    // http://localhost:8080/traduce/????
    @GetMapping("/habitantes/{texto}")
    public String getHabitantes(@PathVariable String texto){
        InfoHabitantes t = populationService.getPopulationFromAPI(texto);
        String result =MessageFormat.format("En {0} hay {1} habitantes" , texto, t.results[0].population); 
        return result;
    }


     // http://localhost:8080/listar
     @GetMapping("/listar")
     public String alumnoList(){
         ArrayList<Alumno> alumnos = alumnoService.getAllAlumnos();
         String listado = "Alumnos registradas:<br/>";
         for(Alumno alumno : alumnos){
             listado +=alumno.getId() + "  ";
             listado += alumno.getName() + "  ";
             listado += alumno.getNota();
             listado += "<br/>";
         }
         return listado;
     }
 
     // http://localhost:8080/guarda?nombre=???&nota=????
     @GetMapping("/guarda")
     public String addAlumno(@RequestParam String nombre, @RequestParam int nota){
         //insert into pet(name) values ("nombre")
         Alumno alumno = new Alumno();
         alumno.setName(nombre);
         alumno.setNota(nota);
         alumnoService.saveAlumno(alumno);
         return "Alumno registrado correctamente";
     }

    

    @GetMapping("/delete")
    public String deleteAlumno(@RequestParam Long Id){
        //insert into pet(name) values ("nombre")
        
        alumnoService.deleteAlumno(Id);
        return "Mascota borrada correctamente";
    }

}
