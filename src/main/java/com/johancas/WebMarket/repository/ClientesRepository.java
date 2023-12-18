package com.johancas.WebMarket.repository;

import com.johancas.WebMarket.model.Clientes;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ClientesRepository extends R2dbcRepository<Clientes,Integer> {

}
