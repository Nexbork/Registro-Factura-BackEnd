package com.example.microserv.service;

import com.example.microserv.entity.EntidadUsuario;
import com.example.microserv.entity.EntidadUsuarioRol;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface ServicioUsuario {

    /*Post*/
    public EntidadUsuario guardarUsuario(EntidadUsuario pEntidadUsuario, Set<EntidadUsuarioRol> pUsuarioRol) throws Exception;
    /*Get*/
    public EntidadUsuario obtenerUsuario(String username);

    /*#$%&/(*/
}
