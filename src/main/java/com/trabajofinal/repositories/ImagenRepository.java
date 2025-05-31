package com.trabajofinal.repositories;

import com.trabajofinal.models.entities.Imagen;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ImagenRepository extends BaseRepository<Imagen, String>{

    List<Imagen> findAllByDetalleProductoId(String idDetalleProducto);
}
