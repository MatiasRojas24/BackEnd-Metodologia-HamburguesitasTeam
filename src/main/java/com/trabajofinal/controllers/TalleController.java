package com.trabajofinal.controllers;

import com.trabajofinal.models.entities.Talle;
import com.trabajofinal.services.TalleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/talles")
public class TalleController extends BaseController<Talle, String>{
    public TalleController(TalleService talleService) {
        super(talleService);
    }
}
