package com.example.microserv.interfaz;

import com.example.microserv.entity.EntidadUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<EntidadUsuario, Integer> {

    public EntidadUsuario findByaUserUsuario(String pUserUsuario);
}