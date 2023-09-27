package br.com.cielo.bootcampdesafio02.servicies.clienteTests;

import br.com.cielo.bootcampdesafio02.api.controller.ClienteController;
import br.com.cielo.bootcampdesafio02.api.service.ClienteService;
import br.com.cielo.bootcampdesafio02.api.service.exceptions.EntityNotFound;
import br.com.cielo.bootcampdesafio02.domain.entity.Cliente;
import br.com.cielo.bootcampdesafio02.domain.repository.ClienteRepository;
import br.com.cielo.bootcampdesafio02.dto.ClienteDTO;
import br.com.cielo.bootcampdesafio02.dto.filters.cliente.ClienteInsertDTO;
import br.com.cielo.bootcampdesafio02.dto.filters.cliente.ClienteUpdateDTO;
import br.com.cielo.bootcampdesafio02.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.mockito.*;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ClienteServiceTest {

    @InjectMocks
    private ClienteService service;
    @Mock
    private ClienteRepository repository;
    private Long existId;
    private Long nonExistId;
    private Long dependentId;
    private Cliente cliente;
    private PageImpl<Cliente> page;
    private ClienteDTO clienteDTO;
    private ClienteInsertDTO clienteInsertDTO;
    private ClienteUpdateDTO clienteUpdateDTO;

    @BeforeEach
    void setUo() throws Exception {
        existId =1L;
        nonExistId = 2L;
        dependentId = 3L;
        cliente = Factory.createCliente();
        page = new PageImpl<>(List.of(cliente));

        //findAll
        when(repository.findAll((Pageable) ArgumentMatchers.any())).thenReturn(page);
        //save
        when(repository.save(ArgumentMatchers.any())).thenReturn(cliente);
        //FindById
        when(repository.findById(existId)).thenReturn(Optional.of(cliente));
        when(repository.findById(nonExistId)).thenReturn(Optional.empty());
        Mockito.doThrow(EntityNotFound.class).when(repository).findById(nonExistId);
        //oneGet
        when(repository.getOne(existId)).thenReturn(cliente);
        when(repository.getOne(nonExistId)).thenThrow(EntityNotFound.class);

    }
    @Test
    public void findAllPageShouldReturnPage(){
        Pageable pageable = PageRequest.of(0,10);
        Page<ClienteDTO> result = service.findAllPaged(pageable);

        Assertions.assertNotNull(result);
        Mockito.verify(repository).findAll(pageable);
    }
    @Test
    public void findByIdShouldResourceNotFoundExceptionWhenIdNotExist(){
        Assertions.assertThrows(EntityNotFound.class,()->{
            service.findById(nonExistId);
        });
        Mockito.doThrow(EntityNotFound.class).when(repository).findById(nonExistId);
    }
    @Test
    public void findByIdShouldReturnProductDTOWhenIdExist(){
        ClienteDTO clienteDTO1 = service.findById(existId);
        Assertions.assertNotNull(clienteDTO1);
        Mockito.verify(repository).findById(existId);
    }
    @Test
    public void updateShouldResourceNotFoundExceptionWhenIdNotExist(){
        Assertions.assertThrows(EntityNotFound.class,()->{
            service.update(nonExistId,clienteUpdateDTO);
        });
    }
}
