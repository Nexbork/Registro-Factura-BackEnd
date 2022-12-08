package com.example.microserv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class EntidadUsuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer aIdUsuario;

    @Column(name = "userusuario")
    private String aUserUsuario;

    @Column(name = "passwordusuario")
    private String aPasswordUsuario;

    @Column(name = "nombreusuario")
    private String aNombreUsuario;

    @Column(name = "apellidousuario")
    private String aApellidoUsuario;

    @Column(name = "emailusuario")
    private String aEmailUsuario;

    @Column(name = "telefono")
    private String aTelefono;

    @Column(name = "enableusuario")
    private Boolean aEnableUsuario;

    @Column(name = "perfilusuario")
    private String aPerfilUsuario;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
    @JsonIgnore
    private Set<EntidadUsuarioRol> usuariorol = new HashSet<>();

    public Integer getaIdUsuario() {
        return aIdUsuario;
    }

    public void setaIdUsuario(Integer aIdUsuario) {
        this.aIdUsuario = aIdUsuario;
    }

    public String getaUserUsuario() {
        return aUserUsuario;
    }

    public void setaUserUsuario(String aUserUsuario) {
        this.aUserUsuario = aUserUsuario;
    }

    public String getaPasswordUsuario() {
        return aPasswordUsuario;
    }

    public void setaPasswordUsuario(String aPasswordUsuario) {
        this.aPasswordUsuario = aPasswordUsuario;
    }

    public String getaNombreUsuario() {
        return aNombreUsuario;
    }

    public void setaNombreUsuario(String aNombreUsuario) {
        this.aNombreUsuario = aNombreUsuario;
    }

    public String getaApellidoUsuario() {
        return aApellidoUsuario;
    }

    public void setaApellidoUsuario(String aApellidoUsuario) {
        this.aApellidoUsuario = aApellidoUsuario;
    }

    public String getaEmailUsuario() {
        return aEmailUsuario;
    }

    public void setaEmailUsuario(String aEmailUsuario) {
        this.aEmailUsuario = aEmailUsuario;
    }

    public String getaTelefono() {
        return aTelefono;
    }

    public void setaTelefono(String aTelefono) {
        this.aTelefono = aTelefono;
    }

    public Boolean getaEnableUsuario() {
        return aEnableUsuario;
    }

    public void setaEnableUsuario(Boolean aEnableUsuario) {
        this.aEnableUsuario = aEnableUsuario;
    }

    public String getaPerfilUsuario() {
        return aPerfilUsuario;
    }

    public void setaPerfilUsuario(String aPerfilUsuario) {
        this.aPerfilUsuario = aPerfilUsuario;
    }

    public Set<EntidadUsuarioRol> getUsuariorol() {
        return usuariorol;
    }

    public void setUsuariorol(Set<EntidadUsuarioRol> usuariorol) {
        this.usuariorol = usuariorol;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

            Set<Authority> autorizaciones = new HashSet<>();

            usuariorol.forEach(entidadUsuarioRol -> {
                autorizaciones.add(new Authority(entidadUsuarioRol.getRol().getaNombreRol()));
            });
        return autorizaciones;
        }

    @Override
    public String getPassword() {
        return getaPasswordUsuario();
    }

    @Override
    public String getUsername() {
        return getaUserUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
