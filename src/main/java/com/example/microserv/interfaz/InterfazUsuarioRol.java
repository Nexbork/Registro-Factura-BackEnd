package com.example.microserv.interfaz;

import com.example.microserv.entity.EntidadUsuarioRol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfazUsuarioRol extends CrudRepository<EntidadUsuarioRol, Integer> {
}
