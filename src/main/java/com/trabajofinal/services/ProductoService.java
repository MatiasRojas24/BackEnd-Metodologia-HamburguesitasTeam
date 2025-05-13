package com.trabajofinal.services;

import com.trabajofinal.models.entities.Catalogo;
import com.trabajofinal.models.entities.Producto;
import com.trabajofinal.repositories.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ProductoService extends BaseService<Producto, String>{
    public ProductoService(ProductoRepository productoRepository) {
        super(productoRepository);
    }
    @Autowired
    private ProductoRepository productoRepository;
    @Transactional
    public Producto agregarCatalogo(String idProducto, Catalogo catalogo)throws Exception{
        try {
            Producto producto = productoRepository.findById(idProducto).orElse(null);
            if (producto != null) {
                producto.setCatalogo(catalogo);
                productoRepository.save(producto);
                return producto;
            }else {
                return null;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Producto> listarPorCatalogo(String idCatalogo) throws Exception{
        try {
         return productoRepository.findAllByCatalogoId(idCatalogo);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
