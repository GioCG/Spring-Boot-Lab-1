package com.giovannicarrera.webapp.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giovannicarrera.webapp.biblioteca.model.Libro;
import com.giovannicarrera.webapp.biblioteca.model.Prestamo;
import com.giovannicarrera.webapp.biblioteca.repository.PrestamoRepository;

@Service
public class PrestamoService implements IPrestamoService{

    @Autowired 
    PrestamoRepository prestamoRepository;
    Libro libro;

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
        Integer i=0;
        List<Prestamo> prestamos = ListarPrestamo();
        for(Prestamo c: prestamos){
            if(c.getVigencia().equals(Boolean.TRUE) && !c.getId().equals(prestamo.getId())){
                i++;
            }
        }
        return i >= 3;
    }
    
    @Override
    public Boolean verificarUsuarioPrestamoVigente(Long dpi) {
        List<Prestamo> prestamos = ListarPrestamo();
    for (Prestamo prestamo : prestamos) {
        if (prestamo.getCliente() != null && prestamo.getCliente().getDPI().equals(dpi) && prestamo.getVigencia().equals(Boolean.TRUE)) {
            return true;
        }
    }

    return false;
}

    public Boolean verificarSiLibroEstaDisponible(Prestamo prestamo) {
        Boolean flag = Boolean.FALSE;
        if(((Libro) prestamo.getLibro()).getId().equals(libro.getId()) && libro.getDisponibilidad().equals(Boolean.TRUE)){
            flag = Boolean.TRUE;

        }
        return flag;
    }
}
