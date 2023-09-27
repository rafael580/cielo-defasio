package br.com.cielo.bootcampdesafio01.repositories;

import br.com.cielo.bootcampdesafio01.domain.entity.Cliente;
import br.com.cielo.bootcampdesafio01.domain.repository.ClienteRepository;
import br.com.cielo.bootcampdesafio01.tests.Factory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository repository;


    Long existngId;
    Long nonExistngId;
    @BeforeEach
    void setUp() throws Exception{
        existngId = 1L;
        nonExistngId = 45L;
    }
    @Test
    public void saveShouldPersintWhichIdAutoIncrementWhenIdIsNull() {
        Cliente cliente = Factory.createCliente();
        cliente.setId(null);
        cliente = repository.save(cliente);
        Assertions.assertNotNull(cliente.getId());

    }
    @Test
    public void saveShouldPersintWhichIdAutoIncrementWhenIdNotNull() {
        Cliente cliente = Factory.createCliente();
        cliente = repository.save(cliente);
        Assertions.assertNotNull(cliente.getId());
    }
    @Test
    public void deleteShouldDeleteObjectWhenIdExists(){

        repository.deleteById(existngId);
        Optional<Cliente> result = repository.findById(existngId);
        Assertions.assertFalse(result.isPresent());
    }
    @Test
    public void findByIdShouldReturnOptionalProductWhenIdExist(){
        Optional<Cliente> cliente = repository.findById(existngId);
        Assertions.assertTrue(cliente.isPresent());
    } @Test
    public void findByIdShouldReturnOptionalProductWhenIdNotExist(){
        Optional<Cliente> cliente = repository.findById(nonExistngId);
        Assertions.assertFalse(cliente.isPresent());
    }

}
