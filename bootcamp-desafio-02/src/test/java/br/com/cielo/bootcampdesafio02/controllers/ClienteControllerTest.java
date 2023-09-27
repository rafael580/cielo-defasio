package br.com.cielo.bootcampdesafio02.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.List;


import br.com.cielo.bootcampdesafio02.api.controller.ClienteController;
import br.com.cielo.bootcampdesafio02.api.service.ClienteService;
import br.com.cielo.bootcampdesafio02.api.service.EmpresaService;
import br.com.cielo.bootcampdesafio02.api.service.exceptions.EntityNotFound;
import br.com.cielo.bootcampdesafio02.domain.entity.Cliente;
import br.com.cielo.bootcampdesafio02.dto.ClienteDTO;
import br.com.cielo.bootcampdesafio02.dto.EmpresaDTO;
import br.com.cielo.bootcampdesafio02.tests.Factory;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import java.util.List;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpresaService empresaService;



}