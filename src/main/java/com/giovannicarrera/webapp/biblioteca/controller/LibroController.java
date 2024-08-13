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

import com.giovannicarrera.webapp.biblioteca.model.Libro;
import com.giovannicarrera.webapp.biblioteca.service.LibroService;

@Controller
@RestController
@RequestMapping("libro")
public class LibroController {

    @Autowired
    LibroService libroService;

    //listar
    @GetMapping("/")
    public ResponseEntity<List<Libro>> listarLibro(){
       try {
            return  ResponseEntity.ok(libroService.ListarLibro());
       } catch (Exception e) {
            return  ResponseEntity.badRequest().body(null);
       }
    } 

    // buscar
    @GetMapping("/{id}")
    public ResponseEntity<Libro> busLibroPorId(@PathVariable Long id){
        try{
            Libro libro = libroService.busLibroPorId(id);
            return ResponseEntity.ok(libro);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);

        }
    }

    //agregar
    @PostMapping("/")
    public ResponseEntity<Map<String,String>> agregarLibro(@RequestBody Libro libro){
        Map<String,String> response = new HashMap<>();
        try{
            libroService.guardarLibro(libro);
            response.put("message","Libro se creo");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("message","Error");
            response.put("err","Error al crear el libro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    //editar
    @PutMapping("/{id}")
    public ResponseEntity<Map<String,String>> editarLibro(@PathVariable Long id,@RequestBody Libro libroNuevo){
        Map<String,String> response = new HashMap<>();
        try {
            Libro libro = libroService.busLibroPorId(id);
            libro.setAutor(libroNuevo.getAutor());
            libro.setCategoria(libroNuevo.getCategoria());
            libro.setCluster(libroNuevo.getCluster());
            libro.setDisponibilidad(libroNuevo.getDisponibilidad());
            libro.setEditorial(libroNuevo.getEditorial());
            libro.setIsbn(libroNuevo.getIsbn());
            libro.setNombre(libroNuevo.getNombre());
            libro.setNumeroEstanteria(libroNuevo.getNumeroEstanteria());
            libro.setSinopsis(libroNuevo.getSinopsis());
            libroService.guardarLibro(libro);
            response.put("message","Libro fue modificado ");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Error al editar el libro");
            return ResponseEntity.badRequest().body(response);
        }
    }
    //eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> eliminarLibro(@PathVariable Long id){
        Map<String,String> response = new HashMap<>();
        try {
            Libro libro = libroService.busLibroPorId(id);
            libroService.eliminarLibro(libro);
            response.put("message", "El Libro se elimino");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Error al intentar eliminar el Libro");
            return ResponseEntity.badRequest().body(response);
        }
    }
}

