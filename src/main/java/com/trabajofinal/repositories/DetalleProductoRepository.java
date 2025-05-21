package com.trabajofinal.repositories;

import com.trabajofinal.models.entities.DetalleProducto;
import com.trabajofinal.models.entities.Producto;
import com.trabajofinal.models.entities.enums.Sexo;
import com.trabajofinal.models.entities.enums.TipoProducto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface DetalleProductoRepository extends BaseRepository<DetalleProducto, String>{
    List<DetalleProducto> findAllByTalleId(String idTalle);
    List<DetalleProducto> findAllByProductoId(String idProducto);

    @Query("""
    SELECT DISTINCT d.producto
    FROM DetalleProducto d
    JOIN Precio p ON p.detalleProducto.id = d.id
    WHERE (:idTalle IS NULL OR d.talle.id = :idTalle)
      AND (:tipoProducto IS NULL OR d.producto.tipoProducto = :tipoProducto)
      AND (:sexo IS NULL OR d.producto.sexo = :sexo)
      AND (:minPrecio IS NULL OR p.precioVenta >= :minPrecio)
      AND (:maxPrecio IS NULL OR p.precioVenta <= :maxPrecio)
""")

    List <Producto> findProductosByTalleOrTipoProductoOrSexoOrPrecio(@Param("idTalle")String idTalle, @Param("tipoProducto")TipoProducto tipoProducto, @Param("sexo")Sexo sexo,@Param("minPrecio") Float minPrecio,
                                                                     @Param("maxPrecio") Float maxPrecio);

}
