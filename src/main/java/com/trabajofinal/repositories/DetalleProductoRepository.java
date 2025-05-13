package com.trabajofinal.repositories;

import com.trabajofinal.models.entities.DetalleProducto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface DetalleProductoRepository extends BaseRepository<DetalleProducto, String>{
    List<DetalleProducto> findAllByTalleId(String idTalle);
    List<DetalleProducto> findAllByProductoId(String idProducto);
}
