package com.trabajofinal.services;

import com.trabajofinal.models.entities.Direccion;
import com.trabajofinal.models.entities.OrdenCompra;
import com.trabajofinal.models.entities.Usuario;
import com.trabajofinal.repositories.OrdenCompraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class OrdenCompraService extends BaseService<OrdenCompra, String>{
    public OrdenCompraService(OrdenCompraRepository ordenCompraRepository) {
        super(ordenCompraRepository);
    }
    @Autowired
    private OrdenCompraRepository ordenCompraRepository;
    @Transactional
    public OrdenCompra agregarUsuario(String idOrdenCompra, Usuario usuario) throws Exception  {
        try {
            OrdenCompra ordenCompra = ordenCompraRepository.findById(idOrdenCompra).orElse(null);
            if (ordenCompra != null){
                ordenCompra.setUsuario(usuario);
                ordenCompraRepository.save(ordenCompra);
                return ordenCompra;
            }else {
                return null;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public OrdenCompra agregarDireccion (String idOrdenCompra, Direccion direccion) throws Exception {
        try {
            OrdenCompra ordenCompra = ordenCompraRepository.findById(idOrdenCompra).orElse(null);
            if (ordenCompra != null){
                ordenCompra.setDireccionEnvio(direccion);
                ordenCompraRepository.save(ordenCompra);
                return ordenCompra;
                }else {
                return null;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<OrdenCompra> listarPorUsuario (String idUsuario) throws Exception{
        try {
            return ordenCompraRepository.findAllByUsuarioId(idUsuario);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<OrdenCompra> listarPorDireccion(String idDireccion) throws Exception{
        try {
         return ordenCompraRepository.findAllByDireccionEnvioId(idDireccion);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
