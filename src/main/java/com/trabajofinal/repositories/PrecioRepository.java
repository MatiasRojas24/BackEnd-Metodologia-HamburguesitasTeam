package com.trabajofinal.repositories;

import com.trabajofinal.models.entities.Precio;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PrecioRepository extends BaseRepository<Precio, String>{
    List<Precio> findAllByDetalleProductoId (String idDetalleProducto);
    List<Precio> findAllByDescuentoId (String idDescuento);
}
