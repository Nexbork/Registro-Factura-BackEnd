package com.example.microserv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rol")
public class EntidadRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private Integer aIdRol;

    @Column(name = "nombrerol")
    private String aNombreRol;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
    private Set<EntidadUsuarioRol> usuariorol = new HashSet<>();

    public Integer getaIdRol() {
        return aIdRol;
    }

    public void setaIdRol(Integer aIdRol) {
        this.aIdRol = aIdRol;
    }

    public String getaNombreRol() {
        return aNombreRol;
    }

    public void setaNombreRol(String aNombreRol) {
        this.aNombreRol = aNombreRol;
    }

    public Set<EntidadUsuarioRol> getUsuariorol() {
        return usuariorol;
    }

    public void setUsuariorol(Set<EntidadUsuarioRol> usuariorol) {
        this.usuariorol = usuariorol;
    }
}
