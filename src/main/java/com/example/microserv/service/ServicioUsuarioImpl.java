package com.example.microserv.service;

import com.example.microserv.entity.EntidadUsuario;
import com.example.microserv.entity.EntidadUsuarioRol;
import com.example.microserv.interfaz.RepositorioRol;
import com.example.microserv.interfaz.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class ServicioUsuarioImpl implements ServicioUsuario{

    @Autowired
    private RepositorioUsuario repoUsuario;
    @Autowired
    private RepositorioRol repoRol;

    /*Post*/
    public EntidadUsuario guardarUsuario(EntidadUsuario pEntidadUsuario, Set<EntidadUsuarioRol> pUsuarioRol) throws Exception {
        EntidadUsuario validacion = repoUsuario.findByaUserUsuario(pEntidadUsuario.getaUserUsuario());

        //si existe...
        if (validacion != null)
        {   System.out.println("Usuario ya existe");}
        //no existe...
        else {
            ////guardo roles
            for(EntidadUsuarioRol entidad:pUsuarioRol){
                repoRol.save(entidad.getRol());
            }
            //guardo usuario
            pEntidadUsuario.getUsuariorol().addAll(pUsuarioRol);
            validacion = repoUsuario.save(pEntidadUsuario);
        }
        return validacion;
    }

    /*Get*/
    public EntidadUsuario obtenerUsuario(String username) {
        return (EntidadUsuario) repoUsuario.findByaUserUsuario(username);
    }
}
