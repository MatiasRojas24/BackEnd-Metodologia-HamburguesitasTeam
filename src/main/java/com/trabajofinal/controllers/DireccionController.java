package com.trabajofinal.controllers;

import com.trabajofinal.models.entities.Direccion;
import com.trabajofinal.models.entities.Usuario;
import com.trabajofinal.services.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RestController
@RequestMapping("/direcciones")
public class DireccionController extends BaseController<Direccion, String>{
    public DireccionController(DireccionService direccionService) {
        super(direccionService);
    }
    @Autowired
    public DireccionService direccionService;
    @PostMapping ("/usuarios/{idDireccion}")
    public Optional<Direccion> agregarUsuarios(@RequestBody List<Usuario> usuarios, @PathVariable String idDireccion) throws Exception{
        Direccion direccion = direccionService.agregarUsuarios(idDireccion, usuarios);
        return Optional.ofNullable(direccion);
    }
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<List<Direccion>> listarPorUsuario(@PathVariable String id) throws Exception{
        List<Direccion> listaDirecciones = direccionService.listarPorUsuario(id);
        return ResponseEntity.ok(listaDirecciones);
    }
}
