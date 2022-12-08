package com.example.microserv.controller;


import com.example.microserv.entity.EntidadRol;
import com.example.microserv.entity.EntidadUsuario;
import com.example.microserv.entity.EntidadUsuarioRol;
import com.example.microserv.service.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorUsuario {

    @Autowired
    private ServicioUsuario servicio;

    @PostMapping("/c")
    public EntidadUsuario agregarUsuario(@RequestBody EntidadUsuario jsonEntidadUsuario) throws Exception{


        EntidadRol rol = new EntidadRol();
        rol.setaIdRol(1);
        rol.setaNombreRol("Cliente");

        EntidadUsuarioRol usuarioRol = new EntidadUsuarioRol();
        usuarioRol.setRol(rol);
        usuarioRol.setUsuario(jsonEntidadUsuario);

        Set<EntidadUsuarioRol> lista = new HashSet<>();
        lista.add(usuarioRol);

        return servicio.guardarUsuario(jsonEntidadUsuario, lista);
    }

    @GetMapping("/{codigo}")
    public EntidadUsuario obtenerUsuario(@PathVariable("codigo") String username) {
        return servicio.obtenerUsuario(username);
    }











/*
    @Autowired
    private InterfazUsuario inter;

    @PostMapping
    public void Create(@RequestBody EntidadUsuario pEntidadUsuario){
        inter.save(pEntidadUsuario);
    }

    @GetMapping
    public List<EntidadUsuario> Read() {
        return (List<EntidadUsuario>) inter.findAll();
    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<EntidadUsuario> Read(@PathVariable("codigo") Integer pId){
        EntidadUsuario rescate = inter.findById(pId).orElseThrow();
        return ResponseEntity.ok(rescate);
    }

    @PutMapping
    public void Update(@RequestBody EntidadUsuario pEntidadUsuario){
        inter.save(pEntidadUsuario);
    }

    @DeleteMapping(value = "/{codigo}")
    public void Delete(@PathVariable("codigo") Integer pId){
        inter.deleteById(pId);
    }

    @PutMapping(value = "/{codigo}")
    public void Update2(@PathVariable("codigo") Integer pId, @RequestBody EntidadUsuario json){
        EntidadUsuario rescate = inter.findById(pId).orElseThrow();

        //userusuario
        if(!(json.getaUserUsuario()==null)){
            rescate.setaUserUsuario(json.getaUserUsuario());
        }

        //passwordusuario
        if(!(json.getaPasswordUsuario()==null)){
            rescate.setaPasswordUsuario(json.getaPasswordUsuario());
        }

        //nombreusuario
        if(!(json.getaNombreUsuario()==null)){
            rescate.setaNombreUsuario(json.getaNombreUsuario());
        }

        //apellidousuario
        if(!(json.getaApellidoUsuario()==null)){
            rescate.setaApellidoUsuario(json.getaApellidoUsuario());
        }

        //emailusuario
        if(!(json.getaEmailUsuario()==null)){
            rescate.setaEmailUsuario(json.getaEmailUsuario());
        }

        //telefono
        if(!(json.getaTelefono()==null)){
            rescate.setaTelefono(json.getaTelefono());
        }

        //enableusuario
        if(!(json.getaEnableUsuario()==null)){
            rescate.setaEnableUsuario(json.getaEnableUsuario());
        }

        //perfilusuario
        if(!(json.getaPerfilUsuario()==null)){
            rescate.setaPerfilUsuario(json.getaPerfilUsuario());
        }

        inter.save(rescate);
    }*/
}
