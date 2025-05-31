package com.trabajofinal.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "ordenesDeCompra")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrdenCompra extends BaseEntity implements Serializable {

    private Float total;
    private Integer descuento;
    private String fechaCompra;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "direccion_id")
    private Direccion direccionEnvio;
}
