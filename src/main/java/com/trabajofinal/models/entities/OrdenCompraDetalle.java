package com.trabajofinal.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "ordenComprasDetalles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrdenCompraDetalle extends BaseEntity implements Serializable {


    @ManyToOne
    @JoinColumn(name = "ordenCompra_id")
    private OrdenCompra ordenCompra;

    @ManyToOne
    @JoinColumn(name = "detalleProducto_id")
    private DetalleProducto detalleProducto;

    private Integer cantidad;

    private Float subtotal;
}
