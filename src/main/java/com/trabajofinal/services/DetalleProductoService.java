package com.trabajofinal.services;

import com.trabajofinal.models.entities.DetalleProducto;
import com.trabajofinal.models.entities.Producto;
import com.trabajofinal.models.entities.Talle;
import com.trabajofinal.repositories.DetalleProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class DetalleProductoService extends BaseService<DetalleProducto, String>{
    public DetalleProductoService(DetalleProductoRepository detalleProductoRepository) {
        super(detalleProductoRepository);
    }
    @Autowired
    private DetalleProductoRepository detalleProductoRepository;
    @Transactional
    public DetalleProducto agregarTalle(String idDetalleProducto, Talle talle) throws Exception{
        try {
            DetalleProducto detalleProducto = detalleProductoRepository.findById(idDetalleProducto).orElse(null);
            if (detalleProducto != null){
                detalleProducto.setTalle(talle);
                detalleProductoRepository.save(detalleProducto);
                return detalleProducto;
            } else {
                return null;
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public DetalleProducto agregarProducto(String idDetalleProducto, Producto producto) throws Exception{
        try {
            DetalleProducto detalleProducto = detalleProductoRepository.findById(idDetalleProducto).orElse(null);
            if (detalleProducto != null){
                detalleProducto.setProducto(producto);
                detalleProductoRepository.save(detalleProducto);
                return detalleProducto;
            }else {
                return null;
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<DetalleProducto> listarPorTalle(String idTalle) throws Exception{
        try {
         return detalleProductoRepository.findAllByTalleId(idTalle);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public  List<DetalleProducto> listarPorProducto(String idProducto) throws Exception{
        try {
         return detalleProductoRepository.findAllByProductoId(idProducto);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
