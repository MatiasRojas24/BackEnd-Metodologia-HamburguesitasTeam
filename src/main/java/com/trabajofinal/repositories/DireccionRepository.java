package com.trabajofinal.repositories;

import com.trabajofinal.models.entities.Direccion;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface DireccionRepository extends BaseRepository<Direccion, String>{
    List<Direccion> findAllByUsuariosId(String idUsuario);
}
