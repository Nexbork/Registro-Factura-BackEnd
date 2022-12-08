package com.example.microserv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "detalle")
public class EntidadDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer aIdDetalle;

    public Integer getaIdArticulo() {
        return aIdArticulo;
    }

    public void setaIdArticulo(Integer aIdArticulo) {
        this.aIdArticulo = aIdArticulo;
    }

    public Integer getaIdFactura() {
        return aIdFactura;
    }

    public void setaIdFactura(Integer aIdFactura) {
        this.aIdFactura = aIdFactura;
    }

    @Column(name = "articulo_id_articulo")
    private Integer aIdArticulo;

    @Column(name = "factura_id_factura")
    private Integer aIdFactura;

    public Integer getaIdDetalle() {
        return aIdDetalle;
    }

    public void setaIdDetalle(Integer aIdDetalle) {
        this.aIdDetalle = aIdDetalle;
    }


}
