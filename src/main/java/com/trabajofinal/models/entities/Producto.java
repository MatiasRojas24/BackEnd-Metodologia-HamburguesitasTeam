package com.trabajofinal.models.entities;

import com.trabajofinal.models.entities.enums.Sexo;
import com.trabajofinal.models.entities.enums.TipoProducto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Producto extends BaseEntity implements Serializable {

    private String nombre;
    private TipoProducto tipoProducto;
    private Sexo sexo;

    @ManyToOne
    @JoinColumn(name = "catalogo_id")
    private Catalogo catalogo;

}
