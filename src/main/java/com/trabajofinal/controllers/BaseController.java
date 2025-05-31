package com.trabajofinal.controllers;

import com.trabajofinal.models.entities.BaseEntity;
import com.trabajofinal.services.BaseService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseController<E extends BaseEntity, ID extends Serializable> {
    protected BaseService<E, ID> service;

    public BaseController(BaseService<E, ID> service) {
        this.service = service;
    }
    @GetMapping("/{id}")
    public Optional<E> getById(@PathVariable ID id) throws Exception{
        return service.getById(id);
    }
    
    @GetMapping()
    public ResponseEntity<List<E>>get()throws Exception{
        List<E>entities = service.get();
        return ResponseEntity.ok(entities);
    }
    @PostMapping()
    public ResponseEntity<E> create(@RequestBody E entity) throws Exception{
        E entidadCreada = service.create(entity);
        return ResponseEntity.ok(entidadCreada);
    }
    @PutMapping()
    public ResponseEntity<E> update(@RequestBody E entity) throws Exception{
        E entidadActualizada = service.update(entity);
        return ResponseEntity.ok(entidadActualizada);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable ID id)throws Exception{
        service.delete(id);
        return ResponseEntity.ok("Eliminado con éxito");
    }
    @PatchMapping("/toggle-habilitado/{id}")
    public ResponseEntity<String> toggleHabilitado(@PathVariable ID id) throws Exception{
        service.disableOrEnable(id);
        return ResponseEntity.ok("Estado de habilitado alternado correctamente");
    }
    @GetMapping("/getEnabled")
    public ResponseEntity<List <E>> getEnabled() throws Exception{
        List<E> enabledEntities = service.getAllEnableEntities();
        return ResponseEntity.ok(enabledEntities);
    }
}
