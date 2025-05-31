package com.trabajofinal.controllers;

import com.trabajofinal.models.entities.DetalleProducto;
import com.trabajofinal.models.entities.Producto;
import com.trabajofinal.models.entities.Talle;
import com.trabajofinal.models.entities.enums.Sexo;
import com.trabajofinal.models.entities.enums.TipoProducto;
import com.trabajofinal.services.DetalleProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/detallesProductos")
public class DetalleProductoController extends BaseController<DetalleProducto, String> {
    public DetalleProductoController(DetalleProductoService detalleProductoService) {
        super(detalleProductoService);
    }
    @Autowired
    public DetalleProductoService detalleProductoService;
    @PostMapping("/talles/{idDetalleProducto}")
    public Optional<DetalleProducto> agregarTalle(@RequestBody Talle talle, @PathVariable String idDetalleProducto) throws Exception{
        DetalleProducto detalleProducto = detalleProductoService.agregarTalle(idDetalleProducto, talle);
        return Optional.ofNullable(detalleProducto);
    }
    @PostMapping("/productos/{idDetalleProducto}")
    public Optional<DetalleProducto> agregarProducto(@RequestBody Producto producto,@PathVariable String idDetalleProducto) throws Exception{
        DetalleProducto detalleProducto = detalleProductoService.agregarProducto(idDetalleProducto, producto);
        return Optional.ofNullable(detalleProducto);
    }
    @GetMapping("/talles/{id}")
    public ResponseEntity<List<DetalleProducto>>listarPorTalle(@PathVariable String id) throws Exception{
        List<DetalleProducto> listaDetallesProductos = detalleProductoService.listarPorTalle(id);
        return ResponseEntity.ok(listaDetallesProductos);
    }
    @GetMapping("/productos/{id}")
    public ResponseEntity<List<DetalleProducto>>listarPorProducto(@PathVariable String id) throws Exception{
        List<DetalleProducto> listaDetallesProductos = detalleProductoService.listarPorProducto(id);
        return ResponseEntity.ok(listaDetallesProductos);
    }
    @GetMapping("/productos/filtro")
    public ResponseEntity<List<Producto>> filtrarPorTalleOTipoProductoOSexoOPrecio(
            @RequestParam(required = false) String idTalle,
            @RequestParam(required = false) String tipoProducto,
            @RequestParam(required = false) String sexo,
            @RequestParam(required = false) String minPrecio,
            @RequestParam(required = false) String maxPrecio
    ) throws Exception {

        TipoProducto tipo = (tipoProducto == null || tipoProducto.equalsIgnoreCase("null"))
                ? null
                : TipoProducto.valueOf(tipoProducto.toUpperCase());

        Sexo sexoEnum = (sexo == null || sexo.equalsIgnoreCase("null"))
                ? null
                : Sexo.valueOf(sexo.toUpperCase());

        String idTall = (idTalle == null || idTalle.equalsIgnoreCase("null"))
                ? null
                : idTalle;

        Float minPrecioFloat = (minPrecio == null || minPrecio.equalsIgnoreCase("null"))
                ? null
                : Float.parseFloat(minPrecio);

        Float maxPrecioFloat = (maxPrecio == null || maxPrecio.equalsIgnoreCase("null"))
                ? null
                : Float.parseFloat(maxPrecio);

        List<Producto> productos = detalleProductoService
                .listarProductosPorTalleOrTipoProductoOrSexoOrPrecio(idTall, tipo, sexoEnum, minPrecioFloat, maxPrecioFloat);

        return ResponseEntity.ok(productos);
    }
}
