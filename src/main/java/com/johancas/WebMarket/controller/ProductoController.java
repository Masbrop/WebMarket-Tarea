package com.johancas.WebMarket.controller;

import com.johancas.WebMarket.model.Producto;
import com.johancas.WebMarket.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoController {

    ProductoService productoService;

    @PostMapping("/crearProducto")
    public Mono<Producto> crearProducto(@RequestBody Producto producto){
        return productoService.save(producto);
    }

    @GetMapping("/listaProductos")
    public Flux<Producto> consultarProductos(){
        return productoService.findAll();
    }

    @GetMapping("/listaProductos/{id}")
    public Mono<Producto> consultarProductoId(@PathVariable int id){
        return productoService.findById(id);
    }

    @DeleteMapping("/eliminarProducto/{id}")
    public Mono<Producto> eliminarProductoId(@PathVariable int id){
        return productoService.deleteById(id);
    }

    @PutMapping("/actualizar/{id}")
    public Mono<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto producto){
        return productoService.updateById(id, producto);
    }
}
