package com.example.microserv.controller;

import com.example.microserv.entity.EntidadArticulo;
import com.example.microserv.interfaz.RepositorioArticulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulo")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladoraArticulo {

    @Autowired
    private RepositorioArticulo repo;

    @PostMapping
    public void Create(@RequestBody EntidadArticulo pEntidadArticulo){
        repo.save(pEntidadArticulo);
    }

    @GetMapping
    public List<EntidadArticulo> Read(){ return (List<EntidadArticulo>) repo.findAll();}

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<EntidadArticulo> Read(@PathVariable("codigo") Integer pId) {
        EntidadArticulo rescate = repo.findById(pId).orElseThrow();
        return ResponseEntity.ok(rescate);
    }

    @PutMapping
    public void Update(@RequestBody EntidadArticulo pEntidadArticulo) {
        repo.save(pEntidadArticulo);
    }

    @DeleteMapping(value = "/{codigo}")
    public void Delete(@PathVariable("codigo") Integer pId){
        repo.deleteById(pId);
    }

    @PutMapping(value = "/{codigo}")
    public void Update2(@PathVariable("codigo") Integer pId, @RequestBody EntidadArticulo json){
        EntidadArticulo rescate = repo.findById(pId).orElseThrow();

        if(!(json.getaArticulo() ==null)){
            rescate.setaArticulo(json.getaArticulo());
        }

        repo.save(rescate);
    }
}
