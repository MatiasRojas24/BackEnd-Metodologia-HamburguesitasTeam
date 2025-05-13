package com.trabajofinal.services;

import com.trabajofinal.models.entities.Descuento;
import com.trabajofinal.models.entities.DetalleProducto;
import com.trabajofinal.models.entities.Precio;
import com.trabajofinal.repositories.PrecioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class PrecioService extends BaseService<Precio, String>{
    public PrecioService(PrecioRepository precioRepository) {
        super(precioRepository);
    }
    @Autowired
    private PrecioRepository precioRepository;
    @Transactional
    public Precio agregarDetalleProducto(String idPrecio , DetalleProducto detalleProducto) throws Exception{
        try {
         Precio precio = precioRepository.findById(idPrecio).orElse(null);
         if (precio != null){
             precio.setDetalleProducto(detalleProducto);
             precioRepository.save(precio);
             return precio;
         } else {
             return null;
         }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public Precio agregarDescuento (String idPrecio, Descuento descuento) throws Exception{
        try {
         Precio precio = precioRepository.findById(idPrecio).orElse(null);
         if (precio!= null){
             precio.setDescuento(descuento);
             precioRepository.save(precio);
             return precio;
         }else{
             return null;
         }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Precio> listarPorDetalleProducto (String idDetalleProducto) throws Exception{
        try {
         return precioRepository.findAllByDetalleProductoId(idDetalleProducto);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Precio> listarPorDescuento (String idDescuento) throws Exception{
        try {
            return precioRepository.findAllByDescuentoId(idDescuento);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
