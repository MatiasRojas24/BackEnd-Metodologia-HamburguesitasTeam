package com.trabajofinal.repositories;

import com.trabajofinal.models.entities.OrdenCompra;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface OrdenCompraRepository extends BaseRepository<OrdenCompra, String>{
    List<OrdenCompra> findAllByUsuarioId(String idUsuario);
    List<OrdenCompra> findAllByDireccionEnvioId(String idDireccionEnvio);
}
