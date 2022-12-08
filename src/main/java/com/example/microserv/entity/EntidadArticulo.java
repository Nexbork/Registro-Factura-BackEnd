package com.example.microserv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "articulo")
public class EntidadArticulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdArticulo")
    private Integer aIdArticulo;

    public Integer getaIdArticulo() {
        return aIdArticulo;
    }

    public void setaIdArticulo(Integer aIdArticulo) {
        this.aIdArticulo = aIdArticulo;
    }



    public String getaArticulo() {
        return aArticulo;
    }

    public void setaArticulo(String aArticulo) {
        this.aArticulo = aArticulo;
    }

    @Column(name = "articulo")
    private String aArticulo;
}
