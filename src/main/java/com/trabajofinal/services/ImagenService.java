package com.trabajofinal.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.trabajofinal.models.entities.DetalleProducto;
import com.trabajofinal.models.entities.Imagen;
import com.trabajofinal.repositories.ImagenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Service
public class ImagenService extends BaseService<Imagen, String>{
    public ImagenService(ImagenRepository imagenRepository) {
        super(imagenRepository);
    }
    @Autowired
    private ImagenRepository imagenRepository;

    @Autowired
    private Cloudinary cloudinary;


    @Override
    @Transactional
    public Imagen create(Imagen imagen) throws Exception {
        try {
            MultipartFile file = imagen.getFile();

            if (file != null && !file.isEmpty()) {
                Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                imagen.setUrl(uploadResult.get("secure_url").toString());
                imagen.setPublicId(uploadResult.get("public_id").toString()); //
            }

            return imagenRepository.save(imagen);

        } catch (IOException e) {
            throw new Exception("Error al subir imagen a Cloudinary: " + e.getMessage());
        }
    }
    @Override
    @Transactional
    public void delete(String id) throws Exception {
        try {
            Imagen imagen = imagenRepository.findById(id)
                    .orElseThrow(() -> new Exception("Imagen no encontrada"));

            // Si la imagen tiene publicId, la eliminamos de Cloudinary
            if (imagen.getPublicId() != null && !imagen.getPublicId().isEmpty()) {
                cloudinary.uploader().destroy(imagen.getPublicId(), ObjectUtils.emptyMap());
            }

            imagenRepository.deleteById(id);

        } catch (Exception e) {
            throw new Exception("Error al eliminar imagen: " + e.getMessage());
        }
    }
    @Transactional
    public Imagen agregarDetalleProducto(String idImagen, DetalleProducto detalleProducto) throws Exception{
        try {
            Imagen imagen = imagenRepository.findById(idImagen).orElse(null);
            if (imagen != null){
                imagen.setDetalleProducto(detalleProducto);
                imagenRepository.save(imagen);
                return imagen;
            } else {
                return null;
            }
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Imagen> listarPorDetalleProducto(String idDetalleProducto) throws Exception{
        try {
            return imagenRepository.findAllByDetalleProductoId(idDetalleProducto);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}

