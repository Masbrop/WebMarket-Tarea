package com.johancas.WebMarket.service;

import com.johancas.WebMarket.model.Producto;
import com.johancas.WebMarket.model.ValidacionProducto;
import com.johancas.WebMarket.repository.ProductoRepository;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class ProductoService implements ValidacionProducto {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoService.class);
    private final ProductoRepository productoRepository;

    public Flux<Producto> findAll(){
        return productoRepository.findAll()
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar todos los productos ", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Ningun producto encontrado").getMostSpecificCause()));
    }

    public Mono<Producto> findById(int id){
        return productoRepository.findById(id)
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar un producto con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Producto con id= " + id + " no encontrado").getMostSpecificCause()));
    }

    public Mono<Producto> save(Producto producto){
        return productoRepository.save(producto);
    }

    public Mono<Producto> deleteById(int id){
        return  productoRepository.findById(id)
                .flatMap(producto -> productoRepository.deleteById(id).thenReturn(producto))
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al buscar el producto con el id= " + id);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No se encontro el producto con id= " + id).getMostSpecificCause()));
    }

    public Mono<Producto> updateById(int id, Producto producto){
        return productoRepository.findById(id)
                .flatMap(productoActualizado -> {
                    productoActualizado.setNombre(producto.getNombre());
                    productoActualizado.setCategoria(producto.getCategoria());
                    productoActualizado.setValor(producto.getValor());
                    return productoRepository.save(productoActualizado);
                })
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al buscar el producto " + id);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No se encontro el producto con id= " + id).getMostSpecificCause()));
    }

    @Override
    public String ValidacionProducto(int id) {
        if(StringUtils.isEmpty(String.valueOf(id)) && !ObjectUtils.isEmpty(String.valueOf(id))){
            return "El producto que buscas no se encuentra disponible";
        }else{
            return "El producto que buscas se encuentra disponible";
        }
    }
}