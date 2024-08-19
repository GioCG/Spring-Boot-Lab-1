package com.giovannicarrera.webapp.biblioteca.controller;

import java.util.HashMap;
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

import com.giovannicarrera.webapp.biblioteca.model.Libro;
import com.giovannicarrera.webapp.biblioteca.model.Prestamo;
import com.giovannicarrera.webapp.biblioteca.service.ClienteService;
import com.giovannicarrera.webapp.biblioteca.service.LibroService;
import com.giovannicarrera.webapp.biblioteca.service.PrestamoService;

@Controller
@RestController
@RequestMapping("prestamo")
public class PrestamoController {

    @Autowired
    PrestamoService prestamoService;
    LibroService libroService;
    ClienteService clienteService;

    //listar
    @GetMapping("/")
    public ResponseEntity<?> listarPrestamo(){
        Map<String,String> response = new HashMap<>();
       try {
            return  ResponseEntity.ok(prestamoService.ListarPrestamo());
       } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "no se encontro una lista prestamo");
            return  ResponseEntity.badRequest().body(response);
       }
    } 

    // buscar
    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> busPrestamoPorId(@PathVariable Long id){
        try{
            Prestamo prestamo = prestamoService.busPrestamoPorId(id);
            return ResponseEntity.ok(prestamo);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);

        }
    }

    //agregar
    @PostMapping("/")
    public ResponseEntity<Map<String,String>> agregarPrestamo(@RequestBody Prestamo prestamo){
        Map<String,String> response = new HashMap<>();
        try{
            
            if(prestamoService.verificarUsuarioPrestamoVigente(prestamo.getCliente().getDPI())){
                response.put("message", "El cliente ya tiene un préstamo vigente.");
                return ResponseEntity.badRequest().body(response);
            }
            /* 
            for (Libro libro : prestamo.getLibro()) {
                libro.setDisponibilidad(false);
                libroService.guardarLibro(libro);
            }
            */
            if (prestamo.getLibro().size() > 3) {
                response.put("message", "El prestamo no puede tener mas de 3 libros");
                return ResponseEntity.badRequest().body(response);
            }
            /* 
            for (Libro libro : prestamo.getLibro()) {
                Libro lib = libroService.busLibroPorId(libro.getId());
                if (lib == null || !lib.getDisponibilidad()) {
                    response.put("message", "El libro solucitado no esta disponible");
                    return ResponseEntity.badRequest().body(response);
                }
            }
            */
            prestamoService.guardarPrestamo(prestamo);
            response.put("message","Prestamo se creo");
            return ResponseEntity.ok(response);  
                    
        }catch(Exception e){
            response.put("message","Error");
            response.put("err","Error al crear el prestamo");
            return ResponseEntity.badRequest().body(response);
        }
    }

    //editar
    @PutMapping("/{id}")
    public ResponseEntity<Map<String,String>> editarPrestamo(@PathVariable Long id,@RequestBody Prestamo prestamoNuevo){
        Map<String,String> response = new HashMap<>();
        try {
            Prestamo prestamo = prestamoService.busPrestamoPorId(id);
            prestamo.setFechaDePrestamo(prestamoNuevo.getFechaDePrestamo());
            prestamo.setFechaDeRevolucion(prestamoNuevo.getFechaDeRevolucion());
            prestamo.setVigencia(prestamoNuevo.getVigencia());
            prestamo.setCliente(prestamoNuevo.getCliente());
            prestamo.setEmpleado(prestamoNuevo.getEmpleado());
            prestamoService.guardarPrestamo(prestamo);
            response.put("message", "La categoria se edito");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Error al editar el prestamo");
            return ResponseEntity.badRequest().body(response);
        }
    }

    //eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> eliminarPrestamo(@PathVariable Long id){
        Map<String,String> response = new HashMap<>();
        try {
            Prestamo prestamo = prestamoService.busPrestamoPorId(id);
            prestamoService.eliminarPrestamo(prestamo);
            response.put("message", "El Prestamo se elimino");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Error al intentar eliminar el prestamo");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
