package com.johancas.WebMarket.controller;

import com.johancas.WebMarket.model.Pedido;
import com.johancas.WebMarket.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pedido")
@AllArgsConstructor
public class PedidoController {

    PedidoService pedidoService;

    @PostMapping("/crearPedido")
    public Mono<Pedido> crearProducto(@RequestBody Pedido pedido){
        return pedidoService.save(pedido);
    }
}
