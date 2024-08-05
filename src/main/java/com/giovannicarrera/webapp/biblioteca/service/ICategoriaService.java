package com.giovannicarrera.webapp.biblioteca.service;

import java.util.List;

import com.giovannicarrera.webapp.biblioteca.model.Categoria;

public interface ICategoriaService {

    public List<Categoria> ListarCategoria();

    public void guardarCategoria(Categoria categoria);
    
    public Categoria busCategoriaPorId(Long id);

    public void eliminarCategoria(Categoria categoria);

}
