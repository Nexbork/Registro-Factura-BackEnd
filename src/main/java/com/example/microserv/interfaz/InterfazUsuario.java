package com.example.microserv.interfaz;

import com.example.microserv.entity.EntidadUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfazUsuario extends CrudRepository<EntidadUsuario, Integer> {
}
