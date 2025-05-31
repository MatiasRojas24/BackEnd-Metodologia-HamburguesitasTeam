package com.trabajofinal.services;

import com.trabajofinal.models.entities.Direccion;
import com.trabajofinal.models.entities.Usuario;
import com.trabajofinal.repositories.DireccionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class DireccionService extends BaseService<Direccion, String>{
    public DireccionService(DireccionRepository direccionRepository) {
        super(direccionRepository);
    }
    @Autowired
    private DireccionRepository direccionRepository;
    @Transactional
    public Direccion agregarUsuarios(String idDireccion, List<Usuario> usuarios) throws Exception{
        try {
         Direccion direccion = direccionRepository.findById(idDireccion).orElse(null);
         if (direccion != null){
             direccion.setUsuarios(usuarios);
             direccionRepository.save(direccion);
             return direccion;
         } else {
             return  null;
         }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
    @Transactional
    public List<Direccion> listarPorUsuario(String idUsuario) throws Exception {
        try {
            return direccionRepository.findAllByUsuariosId(idUsuario);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
