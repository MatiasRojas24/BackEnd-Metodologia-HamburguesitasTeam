package com.trabajofinal.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "detallesProductos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DetalleProducto extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "talle_id")
    private Talle talle;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private String color;
    private Boolean estado;



}
