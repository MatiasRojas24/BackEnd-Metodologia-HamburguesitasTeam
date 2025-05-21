package com.trabajofinal.controllers;

import com.trabajofinal.models.entities.Catalogo;
import com.trabajofinal.models.entities.Producto;
import com.trabajofinal.models.entities.enums.Sexo;
import com.trabajofinal.models.entities.enums.TipoProducto;
import com.trabajofinal.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/productos")
public class ProductoController extends BaseController<Producto, String> {
    public ProductoController(ProductoService productoService) {
        super(productoService);
    }
    @Autowired
    private ProductoService productoService;
    @PostMapping ("/catalogos/{idProducto}")
    public Optional<Producto> agregarCatalogo(@RequestBody Catalogo catalogo, @PathVariable String idProducto) throws Exception{
        Producto producto = productoService.agregarCatalogo(idProducto, catalogo);
        return Optional.ofNullable(producto);
    }
    @GetMapping("/catalogos/{id}")
    public ResponseEntity<List<Producto>> listarPorCatalogo(@PathVariable String id) throws Exception{
        List<Producto> listaProductos = productoService.listarPorCatalogo(id);
        return ResponseEntity.ok(listaProductos);
    }
    @GetMapping("/filtro")
    public ResponseEntity<List<Producto>> filtrarPorNombreOSexoOTipoProductoOIdCatalogo(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String tipoProducto,
            @RequestParam(required = false) String sexo,
            @RequestParam(required = false) String idCatalogo
    ) throws Exception {

        TipoProducto tipo = (tipoProducto == null || tipoProducto.equalsIgnoreCase("null"))
                ? null
                : TipoProducto.valueOf(tipoProducto.toUpperCase());

        Sexo sexoEnum = (sexo == null || sexo.equalsIgnoreCase("null"))
                ? null
                : Sexo.valueOf(sexo.toUpperCase());
        String nom = (nombre == null || nombre.equalsIgnoreCase("null"))
                ? null
                : nombre;
        String idCat = (idCatalogo == null || idCatalogo.equalsIgnoreCase("null"))
                ? null
                : idCatalogo;

        List<Producto> productos = productoService
                .listarPorNombreOrSexoOrTipoProductoOrIdCatalogo(nom, tipo, sexoEnum, idCat);

        return ResponseEntity.ok(productos);
    }
}
