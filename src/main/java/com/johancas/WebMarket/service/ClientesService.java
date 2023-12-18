package com.johancas.WebMarket.service;

import com.johancas.WebMarket.model.Clientes;
import com.johancas.WebMarket.model.ValidacionClientes;
import com.johancas.WebMarket.repository.ClientesRepository;
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
public class ClientesService implements ValidacionClientes {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoService.class);

    private final ClientesRepository clientesRepository;

    public Mono<Clientes> save(Clientes clientes){
        return clientesRepository.save(clientes);
    }

    public Flux<Clientes> findAll(){
        return clientesRepository.findAll()
                .onErrorResume(throwable -> {
                    LOGGER.error("Hubo un error al buscar la lista de los clientes ", throwable );
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Ningun cliente encontrado ").getMostSpecificCause()));
    }

    public Mono<Clientes> findById(int id){
        return clientesRepository.findById(id)
                .onErrorResume(throwable -> {
                    LOGGER.error("Hubo error al buscar el cliente con id = " + id , throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No se encontro el cliente con id = " + id).getMostSpecificCause()));
    }

    public Mono<Clientes> deleteById(int id){
        return clientesRepository.findById(id)
                .flatMap(clientes -> clientesRepository.deleteById(id).thenReturn(clientes))
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al eliminar el cliente con id = " + id);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No se encontro el cliente con id = " + id).getMostSpecificCause()));
    }

    public Mono<Clientes> updateById(int id, Clientes clientes) {
        return clientesRepository.findById(id)
                .flatMap(clienteActualizado -> {
                    clienteActualizado.setNombre(clientes.getNombre());
                    clienteActualizado.setDireccion(clientes.getDireccion());
                    clienteActualizado.setTelefono(clientes.getTelefono());
                    return clientesRepository.save(clienteActualizado);
                })
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al actualizar el cliente con id = " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No se encontro el cliente con id = " + id).getMostSpecificCause()));
    }

    @Override
    public String ValidacionClientes(int id){
        if(StringUtils.isEmpty(String.valueOf(id)) && !ObjectUtils.isEmpty(String.valueOf(id))){
            return "El producto que buscas no se encuentra disponible";
        }else{
            return "El producto que buscas se encuentra disponible";
        }
    }
}