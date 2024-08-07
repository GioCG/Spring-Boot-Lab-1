package com.giovannicarrera.webapp.biblioteca.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name="Prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date FechaDePrestamo;
    private Date FechaDeRevolucion;
    private Boolean Vigencia;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Empleado empleado;
    @ManyToOne
    private Libro libro;
}
