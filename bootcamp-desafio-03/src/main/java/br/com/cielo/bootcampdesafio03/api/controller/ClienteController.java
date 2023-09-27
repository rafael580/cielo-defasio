package br.com.cielo.bootcampdesafio03.api.controller;


import br.com.cielo.bootcampdesafio03.api.service.ClienteService;
import br.com.cielo.bootcampdesafio03.dto.ClienteDTO;

import br.com.cielo.bootcampdesafio03.dto.filters.cliente.ClienteInsertDTO;
import br.com.cielo.bootcampdesafio03.dto.filters.cliente.ClienteUpdateDTO;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clientes")
public class ClienteController {




    @Autowired
    private ClienteService service;


    //     @GetMapping(value = "/primeiro-da-fila-cliente")
    //     public ResponseEntity<ClienteDTO> firstElementRow(){
    //        if(service.filaClientes().isEmpty()){
    //           return ResponseEntity.noContent().build();
    //           }
    //      return ResponseEntity.ok().body(clienteDTO);
    //     }
    @GetMapping
    public ResponseEntity<Page<ClienteDTO>> findAll(Pageable pageAble ){
        Page<ClienteDTO> list = service.findAllPaged(pageAble);
        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id){
        ClienteDTO obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<ClienteDTO> insert(@Valid @RequestBody ClienteInsertDTO clienteInsertDTO){
        ClienteDTO clienteDTO = service.insert(clienteInsertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(clienteDTO.getId()).toUri();
        return  ResponseEntity.created(uri).body(clienteDTO);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO>  update( @PathVariable long id ,@Valid @RequestBody ClienteUpdateDTO clienteUpdateDTO){
        ClienteDTO clienteDTO = service.update(id,clienteUpdateDTO);
        return  ResponseEntity.ok().body(clienteDTO);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
