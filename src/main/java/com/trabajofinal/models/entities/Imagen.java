package com.trabajofinal.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Entity
@Table(name = "imagenes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Imagen extends BaseEntity implements Serializable {
    @Transient
    private MultipartFile file;

    @Column(name = "public_id")
    private String publicId;

    private String url;
    @ManyToOne
    @JoinColumn(name = "detalleProducto_id")
    private DetalleProducto detalleProducto;

}
