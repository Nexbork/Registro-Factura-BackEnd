package com.example.microserv.controller;


import com.example.microserv.entity.EntidadDetalle;
import com.example.microserv.interfaz.InterfazDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladoraDetalle {

    @Autowired
    private InterfazDetalle inter;

    @PostMapping
    public void Create(@RequestBody EntidadDetalle pEntidadDetalle) {
        inter.save(pEntidadDetalle);
    }

    @GetMapping
    public List<EntidadDetalle> Read() {
        return (List<EntidadDetalle>) inter.findAll();
    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<EntidadDetalle> Read(@PathVariable("codigo") Integer pId) {
        EntidadDetalle rescate = inter.findById(pId).orElseThrow();
        return ResponseEntity.ok(rescate);
    }

    @PutMapping
    public void Update(@RequestBody EntidadDetalle pEntidadDetalle){
        inter.save(pEntidadDetalle);
    }

    @DeleteMapping("/{codigo}")
    public void Delete(@PathVariable("codigo") Integer pId){
        inter.deleteById(pId);
    }
}
