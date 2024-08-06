package com.giovannicarrera.webapp.biblioteca.service;

import java.util.List;

import com.giovannicarrera.webapp.biblioteca.model.Empleado;

public interface IEmpleadoService {

    public List<Empleado> ListarEmpleado();

    public void guardarEmpleado(Empleado empleado);
    
    public Empleado busEmpleadoPorId(Long id);

    public void eliminarEmpleado(Empleado empleado);
}
