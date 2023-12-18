package com.johancas.WebMarket.repository;

import com.johancas.WebMarket.model.Pedido;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface PedidoRepository extends R2dbcRepository<Pedido,Integer> {

}
