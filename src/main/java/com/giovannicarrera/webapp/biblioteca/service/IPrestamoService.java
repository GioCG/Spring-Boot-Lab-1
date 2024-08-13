package com.giovannicarrera.webapp.biblioteca.service;

import java.util.List;

import com.giovannicarrera.webapp.biblioteca.model.Prestamo;

public interface IPrestamoService {

    public List<Prestamo> ListarPrestamo();

    public void guardarPrestamo(Prestamo prestamo);
    
    public Prestamo busPrestamoPorId(Long id);

    public void eliminarPrestamo(Prestamo prestamo);

    public Boolean verificarMasDeTresLibros(Prestamo prestamo);

    public Boolean verificarUsuarioPrestamoVigente(Prestamo prestamo);

    public Boolean verificarSiLibroEstaDisponible(Prestamo prestamo);

}
