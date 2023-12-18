package com.johancas.WebMarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Data
@Table("clientes")
public class Clientes {

    @Id
    private int id;
    private String nombre;
    private String telefono;
    private String direccion;
}
