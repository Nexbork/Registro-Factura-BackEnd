package com.example.microserv.interfaz;

import com.example.microserv.entity.EntidadDetalle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfazDetalle extends CrudRepository<EntidadDetalle, Integer> {
}
