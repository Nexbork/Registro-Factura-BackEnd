package com.example.microserv.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "factura")
public class EntidadFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Integer aIdFactura;

    @Column(name = "id_cliente")
    private String aIdCliente;

    @Column(name = "fecha")
    private String aFecha;

    public Integer getaIdFactura() {
        return aIdFactura;
    }

    public void setaIdFactura(Integer aIdFactura) {
        this.aIdFactura = aIdFactura;
    }

    public String getaIdCliente() {
        return aIdCliente;
    }

    public void setaIdCliente(String aIdCliente) {
        this.aIdCliente = aIdCliente;
    }

    public String getaFecha() {
        return aFecha;
    }

    public void setaFecha(String aFecha) {
        this.aFecha = aFecha;
    }

}
