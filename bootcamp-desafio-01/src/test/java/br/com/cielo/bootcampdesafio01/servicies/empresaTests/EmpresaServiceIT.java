package br.com.cielo.bootcampdesafio01.servicies.empresaTests;

import br.com.cielo.bootcampdesafio01.api.service.EmpresaService;
import br.com.cielo.bootcampdesafio01.domain.repository.EmpresaRepository;
import br.com.cielo.bootcampdesafio01.dto.ClienteDTO;
import br.com.cielo.bootcampdesafio01.dto.EmpresaDTO;
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
public class EmpresaServiceIT {

    @Autowired
    private EmpresaService service;
    @Autowired
    private EmpresaRepository repository;

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
        Page<EmpresaDTO> empresaDTOS = service.findAllPaged(page);
        Assertions.assertFalse(empresaDTOS.isEmpty());
    }

    @Test
    public void findAllPagedShouldReturnEmptyWhenPageNotExist(){
        PageRequest page = PageRequest.of(40,10);
        Page<EmpresaDTO> empresaDTOPage = service.findAllPaged(page);
        Assertions.assertTrue(empresaDTOPage.isEmpty());
    }
    @Test
    public void findAllPagedShouldReturnOrderPageWhenSortByName(){
        PageRequest page = PageRequest.of(0,10, Sort.by("cnpj"));
        Page<EmpresaDTO> empresaDTOPage = service.findAllPaged(page);
        Assertions.assertFalse(empresaDTOPage.isEmpty());
        Assertions.assertEquals("23412444422111",empresaDTOPage.getContent().get(0).getCnpj());
    }
    @Test
    public void deleteShouldDeleteResourceWhenIdExist(){
        service.delete(existId);
    }


}
