package com.giovannicarrera.webapp.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giovannicarrera.webapp.biblioteca.model.Empleado;
import com.giovannicarrera.webapp.biblioteca.repository.EmpleadoRepository;

@Service
public class EmpleadoService implements IEmpleadoService{

    
    @Autowired 
    EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> ListarEmpleado() {
        return empleadoRepository.findAll();
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public Empleado busEmpleadoPorId(Long id) {
       return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoRepository.delete(empleado);
    }

    @Override
    public Boolean verificarDpiDuplicado(Empleado empleado) {
        Boolean flag = Boolean.FALSE;
        List<Empleado> empleados = ListarEmpleado();
        for(Empleado e : empleados){
            if(e.getDPI().equals(empleado.getDPI()) && !e.getId().equals(empleado.getId())){
                flag = Boolean.TRUE;
            }
        }
        return flag;
    }

}
