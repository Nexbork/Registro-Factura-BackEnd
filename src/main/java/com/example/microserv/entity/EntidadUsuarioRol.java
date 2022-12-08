package com.example.microserv.entity;

import javax.persistence.*;

@Entity
@Table(name = "usuario_rol")
public class EntidadUsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario_rol")
    private Integer aIdUsuarioRol;

    /*@Column(name = "idusuario")
    private Integer aIdUsuario;*/

    /*@Column(name = "idrol")
    private Integer aIdRol;*/

    @ManyToOne
    private EntidadUsuario usuario;

    @ManyToOne
    private EntidadRol rol;

    public EntidadUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(EntidadUsuario usuario) {
        this.usuario = usuario;
    }

    public EntidadRol getRol() {
        return rol;
    }

    public void setRol(EntidadRol rol) {
        this.rol = rol;
    }

    public Integer getaIdUsuarioRol() {
        return aIdUsuarioRol;
    }

    public void setaIdUsuarioRol(Integer aIdUsuarioRol) {
        this.aIdUsuarioRol = aIdUsuarioRol;
    }

    /*public Integer getaIdUsuario() {
        return aIdUsuario;
    }

    public void setaIdUsuario(Integer aIdUsuario) {
        this.aIdUsuario = aIdUsuario;
    }

    public Integer getaIdRol() {
        return aIdRol;
    }

    public void setaIdRol(Integer aIdRol) {
        this.aIdRol = aIdRol;
    }*/
}
