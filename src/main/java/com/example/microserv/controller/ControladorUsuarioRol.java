package com.example.microserv.controller;

import com.example.microserv.entity.EntidadUsuarioRol;
import com.example.microserv.interfaz.InterfazUsuarioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuariorol")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorUsuarioRol {

    @Autowired
    private InterfazUsuarioRol inter;

    @PostMapping
    public void Create(@RequestBody EntidadUsuarioRol pEntidadUsuarioRol){
        inter.save(pEntidadUsuarioRol);
    }

    @GetMapping
    public List<EntidadUsuarioRol> Read(){
        return (List<EntidadUsuarioRol>) inter.findAll();
    }

    @PutMapping
    public void Update(@RequestBody EntidadUsuarioRol pEntidadUsuarioRol){
        inter.save(pEntidadUsuarioRol);
    }

    @DeleteMapping(value = "/{codigo}")
    public void Delete(@PathVariable("codigo") Integer pId){
        inter.deleteById(pId);
    }

    /*@PutMapping(value = "/{codigo}")
    public void Update2(@PathVariable("codigo") Integer pId,@RequestBody EntidadUsuarioRol json){
        EntidadUsuarioRol rescate = inter.findById(pId).orElseThrow();

        //idusuario
        if(!(json.getaIdUsuario()==null)){
            rescate.setaIdUsuario(json.getaIdUsuario());
        }

        //idrol
        if(!(json.getaIdRol()==null)){
            rescate.setaIdRol(json.getaIdRol());
        }

        inter.save(rescate);
    }*/
}
