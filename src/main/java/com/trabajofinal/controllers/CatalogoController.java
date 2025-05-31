package com.trabajofinal.controllers;

import com.trabajofinal.models.entities.Catalogo;
import com.trabajofinal.services.CatalogoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
@RequestMapping("/catalogos")
public class CatalogoController extends BaseController<Catalogo, String>{
    public CatalogoController(CatalogoService catalogoService) {
        super(catalogoService);
    }
}
