package com.example.microserv.controller;

import com.example.microserv.entity.EntidadFactura;
import com.example.microserv.interfaz.RepositorioFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/factura")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladoraFactura {

    @Autowired
    private RepositorioFactura  inter;

    @PostMapping
    public void Create(@RequestBody EntidadFactura pEntidadFactura) {
        inter.save(pEntidadFactura);
    }

    @GetMapping
    public List<EntidadFactura> Read() {
        return (List<EntidadFactura>) inter.findAll();
    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<EntidadFactura> Read(@PathVariable("codigo") Integer pId) {
        EntidadFactura rescate = inter.findById(pId).orElseThrow();
        return ResponseEntity.ok(rescate);
    }

    @PutMapping
    public void Update(@RequestBody EntidadFactura pEntidadFactura){
        inter.save(pEntidadFactura);
    }

    @DeleteMapping("/{codigo}")
    public void Delete(@PathVariable("codigo") Integer pId){
        inter.deleteById(pId);
    }
}
