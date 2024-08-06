package com.giovannicarrera.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giovannicarrera.webapp.biblioteca.model.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo,Long>{

}
