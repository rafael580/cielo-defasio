package br.com.cielo.bootcampdesafio01.entity;

import br.com.cielo.bootcampdesafio01.domain.entity.Cliente;
import br.com.cielo.bootcampdesafio01.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClienteEntityTest {
    private String coringa;


    @Test
    public void createAt_exist(){
        Cliente cliente =  Factory.createCliente();
        cliente.prePersist();
        Assertions.assertNotNull(cliente.getCreateAt());
    }
    @Test
    public void updateAt_exist(){
        Cliente cliente =  Factory.createCliente();
        cliente.preUpdate();
        Assertions.assertNotNull(cliente.getCreateUpdateAt());
    }


    @Test
    public void cliente_test(){
        Cliente cliente = Factory.createCliente();
        Assertions.assertNotNull(cliente);
    }
    @Test
    public void cliente_test_constructor_void(){
        Cliente cliente = new Cliente();
        Assertions.assertNotNull(cliente);
    }
    @Test
    public void get_creatAt(){
        Cliente cliente = Factory.createCliente();
        Assertions.assertNull(cliente.getCreatedAt());
    }
    @Test
    public void get_updadeAt(){
        Cliente cliente = Factory.createCliente();
        Assertions.assertNull(cliente.getCreateUpdateAt());
    }

    @Test
    public void get_id(){
        Cliente cliente = Factory.createCliente();
        Assertions.assertNotNull(cliente.getId());
    }
    @Test
    public void get_nome(){
        Cliente cliente = Factory.createCliente();
        Assertions.assertNotNull(cliente.getNome());
    }
    @Test
    public void get_email(){
        Cliente cliente = Factory.createCliente();
        Assertions.assertNotNull(cliente.getEmail());
    }
    @Test
    public void get_cpf(){
        Cliente cliente = Factory.createCliente();
        Assertions.assertNotNull(cliente.getCpf());
    }
    @Test
    public void get_mcc(){
        Cliente cliente = Factory.createCliente();
        Assertions.assertNotNull(cliente.getMcc());
    }

    @Test
    public void set_nome(){
        coringa = "joao";
        Cliente cliente = Factory.createCliente();
        cliente.setNome(coringa);
        Assertions.assertEquals(coringa,cliente.getNome());
    }
    @Test
    public void set_cpf(){
        coringa = "12345678910";
        Cliente cliente = Factory.createCliente();
        cliente.setCpf(coringa);
        Assertions.assertEquals(coringa,cliente.getCpf());
    }
    @Test
    public void set_mcc(){
        coringa = "0000";
        Cliente cliente = Factory.createCliente();
        cliente.setMcc(coringa);
        Assertions.assertEquals(coringa,cliente.getMcc());
    }
    @Test
    public void set_email(){
        coringa = "joao@gmail.com";
        Cliente cliente = Factory.createCliente();
        cliente.setEmail(coringa);
        Assertions.assertEquals(coringa,cliente.getEmail());
    }
    @Test
    public void set_email_null(){
        Cliente cliente = Factory.createCliente();
        cliente.setEmail(null);
        Assertions.assertEquals(coringa,cliente.getEmail());
    }
    @Test
    public void set_nome_null(){
        Cliente cliente = Factory.createCliente();
        cliente.setNome(null);
        Assertions.assertEquals(coringa,cliente.getNome());
    }
    @Test
    public void set_mcc_null(){
        Cliente cliente = Factory.createCliente();
        cliente.setMcc(null);
        Assertions.assertEquals(coringa,cliente.getMcc());
    }
    @Test
    public void set_cpf_null(){
        Cliente cliente = Factory.createCliente();
        cliente.setCpf(null);
        Assertions.assertEquals(coringa,cliente.getCpf());
    }
}
