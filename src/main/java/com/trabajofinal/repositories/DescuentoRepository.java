package com.trabajofinal.repositories;

import com.trabajofinal.models.entities.Descuento;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DescuentoRepository extends BaseRepository<Descuento, String>{
}
