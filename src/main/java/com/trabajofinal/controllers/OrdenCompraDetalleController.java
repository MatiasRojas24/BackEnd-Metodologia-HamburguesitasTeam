package com.trabajofinal.controllers;

import com.trabajofinal.models.entities.DetalleProducto;
import com.trabajofinal.models.entities.OrdenCompra;
import com.trabajofinal.models.entities.OrdenCompraDetalle;
import com.trabajofinal.services.OrdenCompraDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordenComprasDetalles")
public class OrdenCompraDetalleController extends BaseController<OrdenCompraDetalle, String>{
    public OrdenCompraDetalleController(OrdenCompraDetalleService ordenCompraDetalleService) {
        super(ordenCompraDetalleService);
    }
    @Autowired
    private OrdenCompraDetalleService ordenCompraDetalleService;
    @PostMapping ("/ordenCompras/{idOrdenCompraDetalle}")
    public Optional<OrdenCompraDetalle> agregarOrdenCompra (@RequestBody OrdenCompra ordenCompra, @PathVariable String idOrdenCompraDetalle) throws Exception{
        OrdenCompraDetalle ordenCompraDetalle = ordenCompraDetalleService.agregarOrdenCompra(idOrdenCompraDetalle, ordenCompra);
        return Optional.ofNullable(ordenCompraDetalle);
    }
    @PostMapping ("/detallesProductos/{idOrdenCompraDetalle}")
    public Optional<OrdenCompraDetalle> agregarDetalleProducto (@RequestBody DetalleProducto detalleProducto, @PathVariable String idOrdenCompraDetalle) throws Exception{
        OrdenCompraDetalle ordenCompraDetalle = ordenCompraDetalleService.agregarDetalleProducto(idOrdenCompraDetalle, detalleProducto);
        return Optional.ofNullable(ordenCompraDetalle);
    }
    @GetMapping ("/ordenCompras/{id}")
    public ResponseEntity<List<OrdenCompraDetalle>> listarPorOrdenCompra(@PathVariable String id) throws Exception{
        List<OrdenCompraDetalle> listaOrdenCompraDetalle= ordenCompraDetalleService.listarPorOrdenCompra(id);
        return ResponseEntity.ok(listaOrdenCompraDetalle);
    }
    @GetMapping ("/detallesProductos/{id}")
    public ResponseEntity<List<OrdenCompraDetalle>>listarPorDetalleProducto(@PathVariable String id) throws Exception{
        List<OrdenCompraDetalle> listaOrdenCompraDetalle = ordenCompraDetalleService.listarPorDetalleProducto(id);
        return ResponseEntity.ok(listaOrdenCompraDetalle);
    }
}
