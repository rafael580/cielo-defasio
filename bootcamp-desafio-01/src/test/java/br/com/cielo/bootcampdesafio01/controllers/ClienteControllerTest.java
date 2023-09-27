package br.com.cielo.bootcampdesafio01.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;


import br.com.cielo.bootcampdesafio01.api.controller.ClienteController;
import br.com.cielo.bootcampdesafio01.api.service.ClienteService;
import br.com.cielo.bootcampdesafio01.api.service.exceptions.EntityNotFound;
import br.com.cielo.bootcampdesafio01.domain.entity.Cliente;
import br.com.cielo.bootcampdesafio01.dto.ClienteDTO;
import br.com.cielo.bootcampdesafio01.tests.Factory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import java.util.List;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClienteService service;

    @Autowired
    private ObjectMapper objectMapper;

    private ClienteDTO clienteDTO;
    private PageImpl<ClienteDTO> page;
    private Long existId;
    private Long nonExistId;
    private Long associateId;

    @BeforeEach
    void setUp() throws Exception {
        existId = 1L;
        nonExistId = 2L;
        associateId = 3L;
        Cliente cliente = Factory.createCliente();
        clienteDTO = new ClienteDTO(cliente);
        page = new PageImpl<>(List.of(clienteDTO));
        //GET
        when(service.findAllPaged(any())).thenReturn(page);
        when(service.findById(existId)).thenReturn(clienteDTO);
        when(service.findById(nonExistId)).thenThrow(EntityNotFound.class);
        //PUT
        when(service.update(eq(existId),any())).thenReturn(clienteDTO);
        when(service.update(eq(nonExistId),any())).thenThrow(EntityNotFound.class);
        //POST
        when(service.insert(any())).thenReturn(clienteDTO);
        //DELETE
        doNothing().when(service).delete(existId);
        doThrow(EntityNotFound.class).when(service).delete(nonExistId);
    }

}
