package com.johancas.WebMarket.repository;

import com.johancas.WebMarket.model.Producto;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends R2dbcRepository<Producto,Integer>{

}
