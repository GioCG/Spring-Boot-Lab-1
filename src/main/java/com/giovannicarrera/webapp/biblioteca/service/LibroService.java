package com.giovannicarrera.webapp.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giovannicarrera.webapp.biblioteca.model.Libro;
import com.giovannicarrera.webapp.biblioteca.repository.LibroRepository;

@Service
public class LibroService implements ILibroService{

    @Autowired 
    LibroRepository libroRepository;

    @Override
    public List<Libro> ListarLibro() {
        return libroRepository.findAll();
    }

    @Override
    public void guardarLibro(Libro libro) {
        libroRepository.save(libro);
    }

    @Override
    public Libro busLibroPorId(Long id) {
       return libroRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarLibro(Libro libro) {
        libroRepository.delete(libro);
    }
}
