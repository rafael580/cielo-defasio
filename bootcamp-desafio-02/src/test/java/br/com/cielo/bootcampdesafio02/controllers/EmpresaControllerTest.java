package br.com.cielo.bootcampdesafio02.controllers;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import br.com.cielo.bootcampdesafio02.api.service.EmpresaService;
import br.com.cielo.bootcampdesafio02.api.service.exceptions.EntityNotFound;
import br.com.cielo.bootcampdesafio02.domain.entity.Empresa;
import br.com.cielo.bootcampdesafio02.dto.EmpresaDTO;
import br.com.cielo.bootcampdesafio02.tests.Factory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.web.servlet.MockMvc;


import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.ResultActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

@WebMvcTest(EmpresaControllerTest.class)
public class EmpresaControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmpresaService service;
    @Autowired
    private ObjectMapper objectMapper;

    private EmpresaDTO empresaDTO;
    private PageImpl<EmpresaDTO> page;
    private Long existId;
    private Long nonExistId;

    @BeforeEach
    void setUp() throws Exception {
        existId = 1L;
        nonExistId = 2L;
        Empresa empresa = Factory.createEmpresa();
        empresaDTO = new EmpresaDTO(empresa);
        page = new PageImpl<>(List.of(empresaDTO));
        when(service.findAllPaged(any())).thenReturn(page);
        when(service.findById(existId)).thenReturn(empresaDTO);
        when(service.findById(nonExistId)).thenThrow(EntityNotFound.class);
        //PUT
        when(service.update(eq(existId),any())).thenReturn(empresaDTO);
        when(service.update(eq(nonExistId),any())).thenThrow(EntityNotFound.class);
        //POST
        when(service.insert(any())).thenReturn(empresaDTO);
        //DELETE
        doNothing().when(service).delete(existId);
        doThrow(EntityNotFound.class).when(service).delete(nonExistId);
    }
    @Test
    public void deleteShouldDoExceptionWhenIdNotExist() throws Exception{
        ResultActions resultActions = mockMvc.perform(delete("/empresas/{id}",nonExistId)
                .accept(MediaType.APPLICATION_JSON)
        );
        resultActions.andExpect(status().isNotFound());
    }

    @Test
    public void deleteShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
        ResultActions resultActions = mockMvc.perform(delete("/empresas/{id}", nonExistId));

        resultActions.andExpect(status().isNotFound());
    }


}
