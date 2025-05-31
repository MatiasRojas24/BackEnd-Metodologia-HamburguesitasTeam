package com.trabajofinal.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "catalogos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Catalogo extends BaseEntity implements Serializable {

    private String nombre;


}
