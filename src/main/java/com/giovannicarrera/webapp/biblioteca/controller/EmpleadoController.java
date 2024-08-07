package com.giovannicarrera.webapp.biblioteca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giovannicarrera.webapp.biblioteca.model.Empleado;
import com.giovannicarrera.webapp.biblioteca.service.EmpleadoService;

@Controller
@RestController
@RequestMapping("empleado")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    //lsitar 
    @GetMapping("/")
    public ResponseEntity<List<Empleado>> listarEmpleado(){
        try {
            return ResponseEntity.ok(empleadoService.ListarEmpleado());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    //buscar 
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> busEmpleadoProId(@PathVariable Long id){
        try {
            Empleado empleado = empleadoService.busEmpleadoPorId(id);
            return ResponseEntity.ok(empleado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    //agregar
    @PostMapping("/")
    public ResponseEntity<Map<String,String>> agregarEmpleado(@RequestBody Empleado empleado){
        Map<String,String> response = new HashMap<>();
        try {
            empleadoService.guardarEmpleado(empleado);
            response.put("message","El empleado fue creada");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message","Error");
            response.put("err","Error al crear el Empleado");
            return ResponseEntity.badRequest().body(response);
        }
        
    }

    //editar
    @PutMapping("/{id}")
    public ResponseEntity<Map<String,String>> editarCliente(@PathVariable Long id,@RequestBody Empleado empleadoNuevo){
        Map<String,String> response = new HashMap<>();
        try {
            Empleado empleado = empleadoService.busEmpleadoPorId(id);
            empleado.setNombre(empleadoNuevo.getNombre());
            empleado.setApellido(empleadoNuevo.getApellido());
            empleado.setTelefóno(empleadoNuevo.getTelefóno());
            empleado.setDireccion(empleadoNuevo.getDireccion());
            empleado.setDPI(empleadoNuevo.getDPI());
            empleadoService.guardarEmpleado(empleado);
            response.put("message", "El empleado se edito");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "El empleado se edito");
            response.put("err", "Error al intentar editar el empleado");
            return ResponseEntity.badRequest().body(response);
        }
    }
    //eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> eliminarCliente(@PathVariable Long id){
        Map<String,String> response = new HashMap<>();
        try {
            Empleado empleado = empleadoService.busEmpleadoPorId(id);
            empleadoService.eliminarEmpleado(empleado);
            response.put("message", "El empleado se elimino");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Error al intentar eliminar el empleado");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
