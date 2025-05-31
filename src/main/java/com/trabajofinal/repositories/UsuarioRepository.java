package com.trabajofinal.repositories;

import com.trabajofinal.models.entities.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, String>{
    List<Usuario> findAllByDireccionesId(String idDireccion);
    Optional<Usuario> findByUsername(String username);
}
