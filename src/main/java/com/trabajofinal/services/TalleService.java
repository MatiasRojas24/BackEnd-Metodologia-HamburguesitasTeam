package com.trabajofinal.services;

import com.trabajofinal.models.entities.Talle;
import com.trabajofinal.repositories.TalleRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class TalleService extends BaseService<Talle, String>{
    public TalleService(TalleRepository talleRepository) {
        super(talleRepository);
    }
}
