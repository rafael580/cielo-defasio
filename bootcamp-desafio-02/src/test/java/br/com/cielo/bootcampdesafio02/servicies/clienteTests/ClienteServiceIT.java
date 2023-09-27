package br.com.cielo.bootcampdesafio02.servicies.clienteTests;

import br.com.cielo.bootcampdesafio02.api.service.ClienteService;
import br.com.cielo.bootcampdesafio02.domain.repository.ClienteRepository;
import br.com.cielo.bootcampdesafio02.dto.ClienteDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootTest
@Transactional
public class ClienteServiceIT {

    @Autowired
    private ClienteService service;
    @Autowired
    private ClienteRepository repository;


    private Long existId;
    private Long nonExistId;

    @BeforeEach
    void setUo() throws Exception {
        existId = 1L;
        nonExistId = 20L;
    }
    @Test
    public void findAllPagedShouldReturnProductDTO(){
        PageRequest page = PageRequest.of(0,10);
        Page<ClienteDTO> clienteDTOPage = service.findAllPaged(page);
        Assertions.assertFalse(clienteDTOPage.isEmpty());
    }

    @Test
    public void findAllPagedShouldReturnEmptyWhenPageNotExist(){
        PageRequest page = PageRequest.of(40,10);
        Page<ClienteDTO> clienteDTOPage = service.findAllPaged(page);
        Assertions.assertTrue(clienteDTOPage.isEmpty());
    }
    @Test
    public void findAllPagedShouldReturnOrderPageWhenSortByName(){
        PageRequest page = PageRequest.of(0,10, Sort.by("nome"));
        Page<ClienteDTO> clienteDTOPage = service.findAllPaged(page);
        Assertions.assertFalse(clienteDTOPage.isEmpty());
        Assertions.assertEquals("rafael",clienteDTOPage.getContent().get(0).getNome());
    }
    @Test
    public void deleteShouldDeleteResourceWhenIdExist(){
        service.delete(existId);
    }
}
