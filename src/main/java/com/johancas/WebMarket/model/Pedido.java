package com.johancas.WebMarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Data
@Table("pedido")
public class Pedido {

    @Id
    private int id;
    private String nombre;
    private  String cantidad;
    private String direccion;

}
