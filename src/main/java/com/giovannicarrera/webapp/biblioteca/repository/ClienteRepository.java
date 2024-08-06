package com.giovannicarrera.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giovannicarrera.webapp.biblioteca.model.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente,Long>{

}
