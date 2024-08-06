package com.giovannicarrera.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giovannicarrera.webapp.biblioteca.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{

}
