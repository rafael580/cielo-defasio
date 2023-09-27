package br.com.cielo.bootcampdesafio02.servicies.clienteTests;

import br.com.cielo.bootcampdesafio02.api.service.ClienteService;
import br.com.cielo.bootcampdesafio02.api.service.exceptions.EntityNotFound;
import br.com.cielo.bootcampdesafio02.domain.entity.Cliente;
import br.com.cielo.bootcampdesafio02.domain.repository.ClienteRepository;
import br.com.cielo.bootcampdesafio02.dto.ClienteDTO;
import br.com.cielo.bootcampdesafio02.dto.filters.cliente.ClienteInsertDTO;
import br.com.cielo.bootcampdesafio02.dto.filters.cliente.ClienteUpdateDTO;
import br.com.cielo.bootcampdesafio02.dto.filters.empresa.EmpresaUpdateDTO;
import br.com.cielo.bootcampdesafio02.tests.Factory;
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
public class ClienteServiceTests {

    @Autowired
    private ClienteService service;
    private Cliente cliente = Factory.createCliente();
    @Test
    public void clienteService_save_cliente(){
        ClienteInsertDTO cliente = new  ClienteInsertDTO();
        service.insert(cliente);
    }
    @Test
    public void clienteService_update_cliente(){
        ClienteUpdateDTO cliente = new  ClienteUpdateDTO();
        service.update(1l,cliente);
    }
    @Test
    public void clienteService_getById_cliente(){
        service.findById(1l);
    }
    @Test
    public void clienteService_delete_cliente(){

        service.delete(1l);
    }
    @Test
    public void clienteService_getById_cliente_not_exist(){
        Assertions.assertThrows(EntityNotFound.class,()->{
            service.findById(111l);
        });
    }
    @Test
    public void get_page(){
        PageImpl<Cliente> page= new PageImpl<>(List.of(cliente));
        Page<ClienteDTO> clientePage = service.findAllPaged(page.getPageable());
        Assertions.assertNotNull(clientePage);
    }

    @Test
    public void ClienteService_update_cliente_id_not_exist(){
        ClienteUpdateDTO clienteUpdateDTO = new  ClienteUpdateDTO();

        Assertions.assertThrows(JpaObjectRetrievalFailureException.class,()->{
            service.update(144l,clienteUpdateDTO);
        });
    }

    @Test
    public void return_fila_clientDTO(){
         Assertions.assertNotNull(service.filaClientes());
    }

}
