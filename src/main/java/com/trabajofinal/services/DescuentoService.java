package com.trabajofinal.services;

import com.trabajofinal.models.entities.Descuento;
import com.trabajofinal.repositories.DescuentoRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class DescuentoService extends BaseService<Descuento, String>{
    public DescuentoService(DescuentoRepository descuentoRepository){
        super(descuentoRepository);
    }
}
