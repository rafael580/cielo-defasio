package br.com.cielo.bootcampdesafio01.servicies.empresaTests;

import br.com.cielo.bootcampdesafio01.api.service.EmpresaService;

import br.com.cielo.bootcampdesafio01.api.service.exceptions.EntityNotFound;

import br.com.cielo.bootcampdesafio01.domain.entity.Empresa;


import br.com.cielo.bootcampdesafio01.dto.EmpresaDTO;
import br.com.cielo.bootcampdesafio01.dto.filters.empresa.EmpresaInsertDTO;
import br.com.cielo.bootcampdesafio01.dto.filters.empresa.EmpresaUpdateDTO;
import br.com.cielo.bootcampdesafio01.tests.Factory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;

import java.util.List;

@SpringBootTest
@Transactional
public class EmpresaServiceTests {


    @Autowired
    private EmpresaService service;

    private Empresa empresa = Factory.createEmpresa();

    @Test
    public void EmpresaService_save_cliente(){
        EmpresaInsertDTO empresaInsertDTO = new  EmpresaInsertDTO();
        service.insert(empresaInsertDTO);
    }
    @Test
    public void EmpresaService_update_cliente(){
        EmpresaUpdateDTO empresaUpdateDTO = new  EmpresaUpdateDTO();
        service.update(1l,empresaUpdateDTO);
    }
    @Test
    public void EmpresaService_getById_cliente(){
        service.findById(1l);
    }
    @Test
    public void EmpresaService_delete_cliente(){

        service.delete(1l);
    }
    @Test
    public void EmpresaService_getById_cliente_not_exist(){
        Assertions.assertThrows(EntityNotFound.class,()->{
            service.findById(111l);
        });
    }
    @Test
    public void get_page(){
        PageImpl<Empresa> page= new PageImpl<>(List.of(empresa));
        Page<EmpresaDTO> empresaDTOPage = service.findAllPaged(page.getPageable());
        Assertions.assertNotNull(empresaDTOPage);
    }
    @Test
    public void EmpresaService_update_cliente_id_not_exist(){
        EmpresaUpdateDTO empresaUpdateDTO = new  EmpresaUpdateDTO();

        Assertions.assertThrows(JpaObjectRetrievalFailureException.class,()->{
            service.update(144l,empresaUpdateDTO);
        });

    }



}
