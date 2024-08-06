package com.giovannicarrera.webapp.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.giovannicarrera.webapp.biblioteca.model.Prestamo;
import com.giovannicarrera.webapp.biblioteca.repository.PrestamoRepository;

public class PrestamoService implements IPrestamoService{

    @Autowired 
    PrestamoRepository prestamoRepository;

    @Override
    public List<Prestamo> ListarLibro() {
        return prestamoRepository.findAll();
    }

    @Override
    public void guardarLibro(Prestamo prestamo) {
        prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo busLibroPorId(Long id) {
       return prestamoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarLibro(Prestamo prestamo) {
        prestamoRepository.delete(prestamo);
    }
}
