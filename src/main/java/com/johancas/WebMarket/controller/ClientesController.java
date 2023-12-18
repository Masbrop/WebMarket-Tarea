package com.johancas.WebMarket.controller;

import com.johancas.WebMarket.model.Clientes;
import com.johancas.WebMarket.service.ClientesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClientesController {

    ClientesService clientesService;

    @PostMapping("/crearCliente")
    public Mono<Clientes> crearProducto(@RequestBody Clientes clientes){
        return clientesService.save(clientes);
    }

    @GetMapping("/listarClientes")
    public Flux<Clientes> listarClientes(){
        return clientesService.findAll();
    }

    @GetMapping("/cliente/{id}")
    public Mono<Clientes> clienteId(@PathVariable int id){
        return clientesService.findById(id);
    }

    @DeleteMapping("/eliminarCliente/{id}")
    public Mono<Clientes> eliminarClienteId(@PathVariable int id){
        return clientesService.deleteById(id);
    }

    @PutMapping("actualizarCliente/{id}")
    public Mono<Clientes> actualizarClienteId(@PathVariable int id, @RequestBody Clientes clientes){
        return clientesService.updateById(id, clientes);
    }

}
