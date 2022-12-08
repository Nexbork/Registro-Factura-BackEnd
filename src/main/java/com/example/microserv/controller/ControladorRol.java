package com.example.microserv.controller;

import com.example.microserv.entity.EntidadRol;
import com.example.microserv.interfaz.InterfazRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorRol {

    @Autowired
    private InterfazRol inter;

    @PostMapping
    public void Create(@RequestBody EntidadRol pEntidadRol){
        inter.save(pEntidadRol);
    }

    @GetMapping
    public List<EntidadRol> Read(){
        return (List<EntidadRol>) inter.findAll();
    }

    @PutMapping
    public void Update(@RequestBody EntidadRol pEntidadRol){
        inter.save(pEntidadRol);
    }

    @DeleteMapping(value = "/{codigo}")
    public void Delete(@PathVariable("codigo") Integer pId){
        inter.deleteById(pId);
    }

    @PutMapping(value = "/{codigo}")
    public void Update2(@PathVariable("codigo") Integer pId,@RequestBody EntidadRol json){
        EntidadRol rescate = inter.findById(pId).orElseThrow();

        //nombrerol
        if(!(json.getaNombreRol()==null)){
            rescate.setaNombreRol(json.getaNombreRol());
        }

        inter.save(rescate);
    }
}
