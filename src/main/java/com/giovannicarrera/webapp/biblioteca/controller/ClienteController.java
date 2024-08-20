
 package com.giovannicarrera.webapp.biblioteca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giovannicarrera.webapp.biblioteca.model.Cliente;
import com.giovannicarrera.webapp.biblioteca.service.ClienteService;

@Controller
@RestController
@RequestMapping("cliente")
@CrossOrigin(value ="http://127.0.0.1:5500")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    
    //listar
    @GetMapping("/")
    public ResponseEntity<List<Cliente>> listarCliente(){
       try {
            return  ResponseEntity.ok(clienteService.ListarCliente());
       } catch (Exception e) {
            return  ResponseEntity.badRequest().body(null);
       }
    } 
    
    // buscar
    @GetMapping("/{DPI}")
    public ResponseEntity<Cliente> busClientePorId(@PathVariable Long DPI){
        try{
            Cliente cliente = clienteService.busClientePorId(DPI);
            return ResponseEntity.ok(cliente);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);

        }
    }
    
    //agregar
    @PostMapping("/")
    public ResponseEntity<Map<String,Boolean>> agregarCliente(@RequestBody Cliente cliente){
        Map<String,Boolean> response = new HashMap<>();
        try{
            clienteService.guardarCliente(cliente);
            response.put("El cliente fue creado", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }catch(Exception e) {
            response.put("El cliente fue creado", Boolean.FALSE);
            return ResponseEntity.badRequest().body(response);
        }
    }
    //editar
    @PutMapping("/{DPI}")
    public ResponseEntity<Map<String,String>> editarCliente(@PathVariable Long DPI,@RequestBody Cliente clienteNuevo){
        Map<String,String> response = new HashMap<>();
        try {
            Cliente cliente = clienteService.busClientePorId(DPI);
            cliente.setDPI(clienteNuevo.getDPI());
            cliente.setNombre(clienteNuevo.getNombre());
            cliente.setApellido(clienteNuevo.getApellido());
            cliente.setTelefóno(clienteNuevo.getTelefóno());
            clienteService.guardarCliente(cliente);
            response.put("message", "El cliente se edito");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "El cliente se edito");
            response.put("err", "Error al intentar editar el cliente");
            return ResponseEntity.badRequest().body(response);
        }
    }
    //eliminar
    @DeleteMapping("/{DPI}")
    public ResponseEntity<Map<String,String>> eliminarCliente(@PathVariable Long DPI){
        Map<String,String> response = new HashMap<>();
        try {
            Cliente cliente = clienteService.busClientePorId(DPI);
            clienteService.eliminarCliente(cliente);
            response.put("message", "El cliente se elimino");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Error al intentar eliminar el cliente");
            return ResponseEntity.badRequest().body(response);
        }
    }
    
}

