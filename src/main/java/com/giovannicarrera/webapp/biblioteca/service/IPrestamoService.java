package com.giovannicarrera.webapp.biblioteca.service;

import java.util.List;

import com.giovannicarrera.webapp.biblioteca.model.Prestamo;

public interface IPrestamoService {

    public List<Prestamo> ListarLibro();

    public void guardarLibro(Prestamo prestamo);
    
    public Prestamo busLibroPorId(Long id);

    public void eliminarLibro(Prestamo prestamo);
}
