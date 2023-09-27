package br.com.cielo.bootcampdesafio01.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import br.com.cielo.bootcampdesafio01.domain.entity.Cliente;
import br.com.cielo.bootcampdesafio01.domain.entity.Empresa;

import br.com.cielo.bootcampdesafio01.dto.ClienteDTO;
import br.com.cielo.bootcampdesafio01.dto.EmpresaDTO;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Test
    public void updateShouldReturnNotFoundWhenURIDoesNotExist() throws Exception {

        Empresa empresa = Factory.createEmpresa();
        EmpresaDTO empresaDTO = new EmpresaDTO(empresa);
        String jsonBody = objectMapper.writeValueAsString(empresaDTO);

        ResultActions result =
                mockMvc.perform(put("/products/{id}", nonExistingId)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound());
    }
    @Test
    public void findAllShouldReturnSortedPagedWhenSorteByName() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/empresas")
                .accept(MediaType.APPLICATION_JSON)
        );
        resultActions.andExpect(status().isOk());
        resultActions.andExpect(jsonPath("$.content").exists());
    }
    @Test
    public void updateShouldReturnProductDTOWhenIdExists() throws Exception {
        Empresa empresa = Factory.createEmpresa();
        EmpresaDTO empresaDTO = new EmpresaDTO(empresa);
        String jsonBody = objectMapper.writeValueAsString(empresaDTO);

        ResultActions result =
                mockMvc.perform(put("/empresas/{id}", existingId)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.id").value(existingId));
    }
}



