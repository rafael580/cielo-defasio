package br.com.cielo.bootcampdesafio03.api.controller;


import br.com.cielo.bootcampdesafio03.api.service.EmpresaService;
import br.com.cielo.bootcampdesafio03.dto.ClienteDTO;
import br.com.cielo.bootcampdesafio03.dto.EmpresaDTO;
import br.com.cielo.bootcampdesafio03.dto.filters.empresa.EmpresaInsertDTO;
import br.com.cielo.bootcampdesafio03.dto.filters.empresa.EmpresaUpdateDTO;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {


    @Autowired
    private EmpresaService service;


    @GetMapping
    public ResponseEntity<Page<EmpresaDTO>> findAll(Pageable pageAble ){

        Page<EmpresaDTO> list = service.findAllPaged(pageAble);
        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<EmpresaDTO> findById(@PathVariable Long id){
        EmpresaDTO obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<EmpresaDTO> insert(@Valid @RequestBody EmpresaInsertDTO empresaInsertDTO){
        EmpresaDTO empresaDTO = service.insert(empresaInsertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(empresaDTO.getId()).toUri();
        return  ResponseEntity.created(uri).body(empresaDTO);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<EmpresaDTO>  update( @PathVariable long id ,@Valid @RequestBody EmpresaUpdateDTO empresaUpdateDTO){
        EmpresaDTO empresaDTO = service.update(id,empresaUpdateDTO);
        return  ResponseEntity.ok().body(empresaDTO);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
