package com.giovannicarrera.webapp.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name="Clientes")
public class Cliente {
    @Id
    private Long DPI;
    private String nombre;
    private String apellido;
    private String Telefóno;
}
