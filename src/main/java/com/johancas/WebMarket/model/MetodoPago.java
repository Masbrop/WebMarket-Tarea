package com.johancas.WebMarket.model;

import org.springframework.data.annotation.Id;

public class MetodoPago {

    @Id
    private int idMetodoPago;
    private String tipoMetodoPago;
    private String bancoMetodoPago;
}
