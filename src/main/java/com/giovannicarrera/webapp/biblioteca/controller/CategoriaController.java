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

import com.giovannicarrera.webapp.biblioteca.model.Categoria;
import com.giovannicarrera.webapp.biblioteca.service.CategoriaService;

@Controller
@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    //listar
    @GetMapping("/")
    public ResponseEntity<List<Categoria>> listarCategoria(){
       try {
            return  ResponseEntity.ok(categoriaService.ListarCategoria());
       } catch (Exception e) {
            return  ResponseEntity.badRequest().body(null);
       }
    } 
    // buscar
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> busCategoriaPorId(@PathVariable Long id){
        try{
            Categoria categoria = categoriaService.busCategoriaPorId(id);
            return ResponseEntity.ok(categoria);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);

        }
    }
    //agregar
    @PostMapping("/")
    public ResponseEntity<Map<String,Boolean>> agregarCategoria(@RequestBody Categoria categoria){
        Map<String,Boolean> response = new HashMap<>();
        try{
            categoriaService.guardarCategoria(categoria);
            response.put("La categoria fue creada", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }catch(Exception e) {
            response.put("La categoria fue creada", Boolean.FALSE);
            return ResponseEntity.badRequest().body(response);
        }
    }
    //editar
    @PutMapping("/{id}")
    public ResponseEntity<Map<String,String>> editarCategoria(@PathVariable Long id,@RequestBody Categoria categoriaNuevo){
        Map<String,String> response = new HashMap<>();
        try {
            Categoria categoria = categoriaService.busCategoriaPorId(id);
            categoria.setNombreCategoria(categoriaNuevo.getNombreCategoria());
            categoriaService.guardarCategoria(categoria);
            response.put("message", "La categoria se edito");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "La categoria no se pudo edito");
            response.put("err", "Error al intentar editar la categoria");
            return ResponseEntity.badRequest().body(response);
        }
    }
    //eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> eliminarCategoria(@PathVariable Long id){
        Map<String,String> response = new HashMap<>();
        try {
            Categoria categoria = categoriaService.busCategoriaPorId(id);
            categoriaService.eliminarCategoria(categoria);
            response.put("message", "La categoria se elimino");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Error al intentar eliminar la categoria");
            return ResponseEntity.badRequest().body(response);
        }
    }
    
}
