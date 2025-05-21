package com.trabajofinal.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "direcciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Direccion extends BaseEntity implements Serializable {

    private String localidad;
    private String pais;
    private String provincia;
    private String departamento;
    @ManyToMany(mappedBy = "direcciones")
    @Builder.Default
    private List<Usuario>usuarios = new ArrayList<>();
}
