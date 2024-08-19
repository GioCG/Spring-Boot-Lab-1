package com.giovannicarrera.webapp.biblioteca.service;

import java.util.List;

import com.giovannicarrera.webapp.biblioteca.model.Cliente;

public interface IClienteService {

    public List<Cliente> ListarCliente();

    public void guardarCliente(Cliente cliente);
    
    public Cliente busClientePorId(Long DPI);

    public void eliminarCliente(Cliente cliente);

    public Boolean verificarDpiDuplicado(Cliente cliente);

}
