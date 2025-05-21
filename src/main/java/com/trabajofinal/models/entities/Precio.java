package com.trabajofinal.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "precios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Precio extends BaseEntity implements Serializable {

    private Float precioCompra;
    private Float precioVenta;

    @ManyToOne
    @JoinColumn(name = "detalleProducto_id")
    private DetalleProducto detalleProducto;

    @ManyToOne
    @JoinColumn(name = "descuento_id")
    private Descuento descuento;


}
