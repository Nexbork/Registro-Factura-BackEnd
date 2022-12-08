package com.example.microserv.interfaz;

import com.example.microserv.entity.EntidadFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioFactura extends JpaRepository<EntidadFactura, Integer> {
}
