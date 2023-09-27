package br.com.cielo.bootcampdesafio02.repositories;

import br.com.cielo.bootcampdesafio02.domain.entity.Cliente;
import br.com.cielo.bootcampdesafio02.domain.entity.Empresa;
import br.com.cielo.bootcampdesafio02.domain.repository.ClienteRepository;
import br.com.cielo.bootcampdesafio02.domain.repository.EmpresaRepository;
import br.com.cielo.bootcampdesafio02.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class EmpresaRepositoryTest {

    @Autowired
    private EmpresaRepository repository;


    Long existngId;
    Long nonExistngId;
    @BeforeEach
    void setUp() throws Exception{
        existngId = 1L;
        nonExistngId = 45L;
    }
    @Test
    public void saveShouldPersintWhichIdAutoIncrementWhenIdIsNull() {
        Empresa empresa = Factory.createEmpresa();
        empresa.setId(null);
        empresa = repository.save(empresa);
        Assertions.assertNotNull(empresa.getId());

    }
    @Test
    public void saveShouldPersintWhichIdAutoIncrementWhenIdNotNull() {
        Empresa empresa = Factory.createEmpresa();
        empresa = repository.save(empresa);
        Assertions.assertNotNull(empresa.getId());
    }
    @Test
    public void deleteShouldDeleteObjectWhenIdExists(){
        repository.deleteById(existngId);
        Optional<Empresa> result = repository.findById(existngId);
        Assertions.assertFalse(result.isPresent());
    }
    @Test
    public void findByIdShouldReturnOptionalProductWhenIdExist(){
        Optional<Empresa> empresa = repository.findById(existngId);
        Assertions.assertTrue(empresa.isPresent());
    } @Test
    public void findByIdShouldReturnOptionalProductWhenIdNotExist(){
        Optional<Empresa> empresa = repository.findById(nonExistngId);
        Assertions.assertFalse(empresa.isPresent());
    }

}
