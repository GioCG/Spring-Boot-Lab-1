/*
package com.giovannicarrera.webapp.biblioteca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giovannicarrera.webapp.biblioteca.model.Cliente;
import com.giovannicarrera.webapp.biblioteca.service.ClienteService;

@Controller
@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;
        //listar
    @GetMapping("/")
    public List<Cliente> ListarCliente(){
        return clienteService.ListarCliente();
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
}
 */