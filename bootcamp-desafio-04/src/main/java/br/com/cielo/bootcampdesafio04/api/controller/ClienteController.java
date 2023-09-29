package br.com.cielo.bootcampdesafio04.api.controller;


import br.com.cielo.bootcampdesafio04.api.service.ClienteService;
import br.com.cielo.bootcampdesafio04.dto.ClienteDTO;

import br.com.cielo.bootcampdesafio04.dto.filters.cliente.ClienteInsertDTO;
import br.com.cielo.bootcampdesafio04.dto.filters.cliente.ClienteUpdateDTO;



import io.awspring.cloud.sqs.operations.SqsTemplate;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clientes")
@PreAuthorize("hasRole('ADMIN')")

public class ClienteController {


    private final SqsTemplate sqsTemplate;


    public static final String QUEUE = "bootcamp-cielo.fifo";


    @Autowired
    private ClienteService service;

    public ClienteController(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
    }


    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<Page<ClienteDTO>> findAll(Pageable pageAble ){
        Page<ClienteDTO> list = service.findAllPaged(pageAble);
        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin:read')")

    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id){
        ClienteDTO obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")

    public ResponseEntity<ClienteDTO> insert(@Valid @RequestBody ClienteInsertDTO clienteInsertDTO){
        ClienteDTO clienteDTO = service.insert(clienteInsertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(clienteDTO.getId()).toUri();

        sqsTemplate.send(to-> to.queue(QUEUE).payload(clienteDTO));

        return  ResponseEntity.created(uri).body(clienteDTO);
    }
    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin:update')")

    public ResponseEntity<ClienteDTO>  update( @PathVariable long id ,@Valid @RequestBody ClienteUpdateDTO clienteUpdateDTO){
        ClienteDTO clienteDTO = service.update(id,clienteUpdateDTO);
        sqsTemplate.send(to-> to.queue(QUEUE).payload(clienteDTO));
        return  ResponseEntity.ok().body(clienteDTO);
    }
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")

    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
