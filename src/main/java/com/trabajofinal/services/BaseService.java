package com.trabajofinal.services;

import com.trabajofinal.models.entities.BaseEntity;
import com.trabajofinal.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseService<E extends BaseEntity, ID extends Serializable> {
    protected BaseRepository<E, ID> baseRepository;

    public BaseService(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }
    @Transactional
    public Optional<E> getById(ID id) throws Exception{
        try {
            return Optional.ofNullable(baseRepository.findById(id).orElse(null));
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<E> get() throws Exception{
        try {
            System.out.println("Usuarios en DB: " + baseRepository.findAll().size());
            return baseRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public E create(E entity) throws Exception{
        try {
            return baseRepository.save(entity);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public E update(E entity) throws Exception{
        try {
            return baseRepository.save(entity);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public void  delete(ID id) throws Exception{
        try{
            baseRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
