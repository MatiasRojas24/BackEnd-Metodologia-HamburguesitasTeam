package com.trabajofinal.controllers;

import com.trabajofinal.models.entities.DetalleProducto;
import com.trabajofinal.models.entities.Imagen;
import com.trabajofinal.services.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/imagenes")
public class ImagenController extends BaseController<Imagen, String>{
    public ImagenController(ImagenService imagenService) {
        super(imagenService);
    }
    @Autowired
    private ImagenService imagenService;
    @PostMapping("/detallesProductos/{idImagen}")
    public Optional<Imagen> agregarDetalleProducto (@RequestBody DetalleProducto detalleProducto, @PathVariable String idImagen) throws Exception{
        Imagen imagen = imagenService.agregarDetalleProducto(idImagen,detalleProducto);
        return Optional.ofNullable(imagen);
    }
    @GetMapping("/detallesProductos/{id}")
    public ResponseEntity<List<Imagen>> listarPorDetalleProducto (@PathVariable String id) throws Exception{
        List<Imagen> listaImagenes = imagenService.listarPorDetalleProducto(id);
        return ResponseEntity.ok(listaImagenes);
    }
}
