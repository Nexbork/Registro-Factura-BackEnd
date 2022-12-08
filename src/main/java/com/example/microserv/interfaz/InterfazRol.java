package com.example.microserv.interfaz;

import com.example.microserv.entity.EntidadRol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfazRol extends CrudRepository<EntidadRol, Integer> {
}
