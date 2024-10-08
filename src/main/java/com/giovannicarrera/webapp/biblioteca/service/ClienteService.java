package com.giovannicarrera.webapp.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.giovannicarrera.webapp.biblioteca.model.Cliente;
import com.giovannicarrera.webapp.biblioteca.repository.ClienteRepository;

@Service
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

    @Override
    public Boolean verificarDpiDuplicado(Cliente cliente) {
        Boolean flag = Boolean.FALSE;
        List<Cliente> clientes = ListarCliente();
        for(Cliente c : clientes){
            if(c.getDPI().equals(cliente.getDPI())){
                flag = Boolean.TRUE;
            }
        }
        return flag;
    }

    
}
