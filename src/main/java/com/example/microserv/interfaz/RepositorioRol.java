package com.example.microserv.interfaz;

import com.example.microserv.entity.EntidadRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRol extends JpaRepository<EntidadRol,Integer> {
}
