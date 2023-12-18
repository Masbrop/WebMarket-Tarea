package com.johancas.WebMarket.service;

import com.johancas.WebMarket.model.Pedido;
import com.johancas.WebMarket.model.Producto;
import com.johancas.WebMarket.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class PedidoService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoService.class);
    private final PedidoRepository pedidoRepository;

    public Mono<Pedido> save(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

}
