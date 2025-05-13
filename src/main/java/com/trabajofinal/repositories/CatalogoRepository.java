package com.trabajofinal.repositories;

import com.trabajofinal.models.entities.Catalogo;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CatalogoRepository extends BaseRepository<Catalogo, String> {

}
