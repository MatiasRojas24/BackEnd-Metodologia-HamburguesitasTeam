package com.trabajofinal.services;

import com.trabajofinal.models.entities.DetalleProducto;
import com.trabajofinal.models.entities.OrdenCompra;
import com.trabajofinal.models.entities.OrdenCompraDetalle;
import com.trabajofinal.repositories.OrdenCompraDetalleRepository;
import com.trabajofinal.repositories.OrdenCompraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenCompraDetalleService extends BaseService<OrdenCompraDetalle, String>{
    public OrdenCompraDetalleService(OrdenCompraDetalleRepository ordenCompraDetalleRepository) {
        super(ordenCompraDetalleRepository);
    }
    @Autowired
    private OrdenCompraDetalleRepository ordenCompraDetalleRepository;
    @Autowired
    private OrdenCompraRepository ordenCompraRepository;
    @Transactional
    public OrdenCompraDetalle agregarOrdenCompra (String idOrdenCompraDetalle, OrdenCompra ordenCompra) throws Exception{
        try {
            OrdenCompraDetalle ordenCompraDetalle = ordenCompraDetalleRepository.findById(idOrdenCompraDetalle).orElse(null);
            if (ordenCompraDetalle != null){
                ordenCompraDetalle.setOrdenCompra(ordenCompra);
                ordenCompra.setTotal(ordenCompra.getTotal()+ordenCompraDetalle.getSubtotal());
                ordenCompraRepository.save(ordenCompra);
                ordenCompraDetalleRepository.save(ordenCompraDetalle);
                return ordenCompraDetalle;
            } else {
                return null;
            }
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public OrdenCompraDetalle agregarDetalleProducto(String idOrdenCompraDetalle, DetalleProducto detalleProducto) throws Exception{
        try{
            OrdenCompraDetalle ordenCompraDetalle = ordenCompraDetalleRepository.findById(idOrdenCompraDetalle).orElse(null);
        if (ordenCompraDetalle != null){
            ordenCompraDetalle.setDetalleProducto(detalleProducto);
            ordenCompraDetalleRepository.save(ordenCompraDetalle);
            return ordenCompraDetalle;
        }else {
            return null;
        }
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<OrdenCompraDetalle> listarPorOrdenCompra( String idOrdenCompra) throws Exception{
        try {
            return ordenCompraDetalleRepository.findAllByOrdenCompraId(idOrdenCompra);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<OrdenCompraDetalle> listarPorDetalleProducto(String idDetalleProducto) throws Exception{
        try {
            return ordenCompraDetalleRepository.findAllByDetalleProductoId(idDetalleProducto);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
