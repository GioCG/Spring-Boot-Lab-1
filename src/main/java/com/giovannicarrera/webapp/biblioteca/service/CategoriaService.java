package com.giovannicarrera.webapp.biblioteca.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.giovannicarrera.webapp.biblioteca.model.Categoria;
import com.giovannicarrera.webapp.biblioteca.repository.CategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService{

    @Autowired 
    CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> ListarCategoria() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
      return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria busCategoriaPorId(Long id) {
       return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarCategoria(Categoria categoria) {
         categoriaRepository.delete(categoria);
    }

    public Boolean verificarCategoriaDuplicada(Categoria categoria) {
        Boolean flag = Boolean.FALSE;
        List<Categoria> categorias = ListarCategoria();
        for(Categoria c : categorias){
            if(c.getNombre().equals(categoria.getNombre()) && !c.getId().equals(categoria.getId())){
                flag = Boolean.TRUE;
            }
        }
        return flag;
    }

}
