package com.trabajofinal.controllers;

import com.trabajofinal.models.entities.Direccion;
import com.trabajofinal.models.entities.Usuario;
import com.trabajofinal.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BaseController<Usuario, String> {
    public UsuarioController(UsuarioService usuarioService) {
        super(usuarioService);
    }
    @Autowired
    private UsuarioService usuarioService;
    @PostMapping("/direcciones/{idUsuario}")
    public Optional<Usuario> agregarDireccion (@RequestBody List<Direccion> direcciones, @PathVariable String idUsuario) throws Exception {
        Usuario usuario = usuarioService.agregarDirecciones(idUsuario, direcciones);
        return Optional.ofNullable(usuario);
    }
    @GetMapping ("/direcciones/{id}")
    public ResponseEntity<List<Usuario>> listarPorDireccion (@PathVariable String id) throws Exception{
        List<Usuario> listaUsuarios = usuarioService.listarPorDireccion(id);
        return ResponseEntity.ok(listaUsuarios);
    }
}
