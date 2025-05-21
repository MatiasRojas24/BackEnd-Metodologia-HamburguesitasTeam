package com.trabajofinal.repositories;

import com.trabajofinal.models.entities.Producto;
import com.trabajofinal.models.entities.enums.Sexo;
import com.trabajofinal.models.entities.enums.TipoProducto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProductoRepository extends BaseRepository<Producto, String>{
    List<Producto> findAllByCatalogoId(String idCatalogo);

    @Query("""
            SELECT DISTINCT p
            FROM Producto p
            WHERE (:nombre IS NULL OR p.nombre LIKE CONCAT('%', :nombre, '%'))
            AND (:tipoProducto IS NULL OR p.tipoProducto = :tipoProducto)
            AND (:sexo IS NULL OR p.sexo = :sexo)
            AND (:idCatalogo IS NULL OR p.catalogo.id = :idCatalogo)
            """)
    List<Producto> findProductosByNombreOrTipoProductoOrSexoOrCatalogo(
            @Param("nombre") String nombre,
            @Param("tipoProducto") TipoProducto tipoProducto,
            @Param("sexo") Sexo sexo,
            @Param("idCatalogo") String idCatalogo
    );

}
