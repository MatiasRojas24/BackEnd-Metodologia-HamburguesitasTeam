package com.trabajofinal.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "descuentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Descuento extends BaseEntity implements Serializable {

    private String fechaInicio;
    private String fechaCierra;
    private Number descuento;
}
