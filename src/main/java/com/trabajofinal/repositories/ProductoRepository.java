package com.trabajofinal.repositories;

import com.trabajofinal.models.entities.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProductoRepository extends BaseRepository<Producto, String>{
    List<Producto> findAllByCatalogoId(String idCatalogo);

}
