package com.giovannicarrera.webapp.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.giovannicarrera.webapp.biblioteca.model.Cliente;
import com.giovannicarrera.webapp.biblioteca.repository.ClienteRepository;

public class ClienteService implements IClienteService {

    @Autowired 
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> ListarCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Cliente busClientePorId(Long DPI) {
       return clienteRepository.findById(DPI).orElse(null);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}
