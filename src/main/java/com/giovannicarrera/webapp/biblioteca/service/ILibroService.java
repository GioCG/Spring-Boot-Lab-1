package com.giovannicarrera.webapp.biblioteca.service;

import java.util.List;

import com.giovannicarrera.webapp.biblioteca.model.Libro;

public interface ILibroService {

    public List<Libro> ListarLibro();

    public void guardarLibro(Libro libro);
    
    public Libro busLibroPorId(Long id);

    public void eliminarLibro(Libro libro);
}
