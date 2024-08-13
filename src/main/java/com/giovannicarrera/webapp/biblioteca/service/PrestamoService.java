package com.giovannicarrera.webapp.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giovannicarrera.webapp.biblioteca.model.Prestamo;
import com.giovannicarrera.webapp.biblioteca.repository.PrestamoRepository;

@Service
public class PrestamoService implements IPrestamoService{

    @Autowired 
    PrestamoRepository prestamoRepository;

    @Override
    public List<Prestamo> ListarPrestamo() {
        return prestamoRepository.findAll();
    }

    @Override
    public void guardarPrestamo(Prestamo prestamo) {
        prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo busPrestamoPorId(Long id) {
       return prestamoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarPrestamo(Prestamo prestamo) {
        prestamoRepository.delete(prestamo);
    }

    public Boolean verificarMasDeTresLibros(Prestamo prestamo) {
        Boolean flag = Boolean.FALSE;
        return flag;
    }

    @Override
    public Boolean verificarUsuarioPrestamoVigente(Prestamo prestamo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificarUsuarioPrestamoVigente'");
    }

    @Override
    public Boolean verificarSiLibroEstaDisponible(Prestamo prestamo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificarSiLibroEstaDisponible'");
    }
}
