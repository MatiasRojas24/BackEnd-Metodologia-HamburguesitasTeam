package com.trabajofinal.repositories;

import com.trabajofinal.models.entities.OrdenCompraDetalle;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface OrdenCompraDetalleRepository extends BaseRepository<OrdenCompraDetalle, String>{
    List<OrdenCompraDetalle> findAllByOrdenCompraId(String idOrdenCompra);
    List<OrdenCompraDetalle> findAllByProductoId(String idProducto);
}
