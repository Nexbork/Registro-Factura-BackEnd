package com.example.microserv.interfaz;

import com.example.microserv.entity.EntidadArticulo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioArticulo extends CrudRepository<EntidadArticulo,Integer> {
}
