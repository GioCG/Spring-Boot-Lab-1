package com.giovannicarrera.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giovannicarrera.webapp.biblioteca.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
