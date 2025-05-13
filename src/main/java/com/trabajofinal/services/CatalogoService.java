package com.trabajofinal.services;

import com.trabajofinal.models.entities.Catalogo;

import com.trabajofinal.repositories.CatalogoRepository;
import org.springframework.stereotype.Service;


import java.util.UUID;
@Service
public class CatalogoService extends BaseService<Catalogo, String>{
    public CatalogoService(CatalogoRepository catalogoRepository) {
        super(catalogoRepository);
    }
}
