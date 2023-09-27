package br.com.cielo.bootcampdesafio01.controllers;

import br.com.cielo.bootcampdesafio01.domain.entity.Empresa;
import br.com.cielo.bootcampdesafio01.dto.EmpresaDTO;
import br.com.cielo.bootcampdesafio01.dto.filters.empresa.EmpresaInsertDTO;
import br.com.cielo.bootcampdesafio01.dto.filters.empresa.EmpresaUpdateDTO;
import br.com.cielo.bootcampdesafio01.tests.Factory;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class EmpresaControllerIT {


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private Long existingId;
    private Long nonExistingId;

    @BeforeEach
    void setUo() throws Exception {
        existingId =1L;
        nonExistingId = 2000L;
    }

  
}



