package br.com.cielo.bootcampdesafio02.servicies.empresaTests;

import br.com.cielo.bootcampdesafio02.api.service.EmpresaService;
import br.com.cielo.bootcampdesafio02.api.service.exceptions.EntityNotFound;
import br.com.cielo.bootcampdesafio02.domain.entity.Cliente;
import br.com.cielo.bootcampdesafio02.domain.entity.Empresa;
import br.com.cielo.bootcampdesafio02.domain.repository.EmpresaRepository;
import br.com.cielo.bootcampdesafio02.dto.ClienteDTO;
import br.com.cielo.bootcampdesafio02.dto.EmpresaDTO;
import br.com.cielo.bootcampdesafio02.dto.filters.cliente.ClienteInsertDTO;
import br.com.cielo.bootcampdesafio02.dto.filters.cliente.ClienteUpdateDTO;
import br.com.cielo.bootcampdesafio02.dto.filters.empresa.EmpresaInsertDTO;
import br.com.cielo.bootcampdesafio02.dto.filters.empresa.EmpresaUpdateDTO;
import br.com.cielo.bootcampdesafio02.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class EmpresaServiceTest {

    @InjectMocks
    private EmpresaService service;
    @Mock
    private EmpresaRepository repository;

    private Long existId;
    private Long nonExistId;
    private Long dependentId;
    private Empresa empresa;
    private PageImpl<Empresa> page;
    private EmpresaDTO empresaDTO;

    private EmpresaInsertDTO empresaInsertDTO;
    private EmpresaUpdateDTO empresaUpdateDTO;

    @BeforeEach
    void setUo() throws Exception {
        existId = 1L;
        nonExistId = 2L;
        dependentId = 3L;
        empresa = Factory.createEmpresa();
        page = new PageImpl<>(List.of(empresa));

        //findAll
        Mockito.when(repository.findAll((Pageable) ArgumentMatchers.any())).thenReturn(page);
        //save
        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(empresa);
        //FindById
        Mockito.when(repository.findById(existId)).thenReturn(Optional.of(empresa));
        Mockito.when(repository.findById(nonExistId)).thenReturn(Optional.empty());
        Mockito.doThrow(EntityNotFound.class).when(repository).findById(nonExistId);
        //oneGet
        Mockito.when(repository.getOne(existId)).thenReturn(empresa);
        Mockito.when(repository.getOne(nonExistId)).thenThrow(EntityNotFound.class);
    }

    @Test
    public void findAllPageShouldReturnPage(){
        Pageable pageable = PageRequest.of(0,10);
        Page<EmpresaDTO> result = service.findAllPaged(pageable);

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
        EmpresaDTO empresaDTO1 = service.findById(existId);
        Assertions.assertNotNull(empresaDTO1);
        Mockito.verify(repository).findById(existId);
    }
    @Test
    public void updateShouldResourceNotFoundExceptionWhenIdNotExist(){
        Assertions.assertThrows(EntityNotFound.class,()->{
            service.update(nonExistId,empresaUpdateDTO);
        });
    }




}
