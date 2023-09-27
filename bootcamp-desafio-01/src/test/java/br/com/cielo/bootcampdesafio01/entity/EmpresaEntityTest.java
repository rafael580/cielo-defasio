package br.com.cielo.bootcampdesafio01.entity;

import br.com.cielo.bootcampdesafio01.domain.entity.Empresa;
import br.com.cielo.bootcampdesafio01.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmpresaEntityTest {

    private String coringa;


    @Test
    public void constructor_exist(){
        Empresa empresa =  Factory.createEmpresa();
        Assertions.assertNotNull(empresa);
    }
    @Test
    public void constructor_void(){
        Empresa empresa = new Empresa();
        Assertions.assertNotNull(empresa);
    }
    @Test
    public void createAt_exist(){
        Empresa empresa =  Factory.createEmpresa();
        empresa.prePersist();
        Assertions.assertNotNull(empresa.getCreateAt());
    }
    @Test
    public void Update_At_exist(){
        Empresa empresa =  Factory.createEmpresa();
        empresa.preUpdate();
        Assertions.assertNotNull(empresa.getCreatedUpdateAt());
    }


    @Test
    public void creat_at(){
        Empresa empresa =  Factory.createEmpresa();
        Assertions.assertNull(empresa.getCreatedAt());
    }

    @Test
    public void updade_at(){
        Empresa empresa =  Factory.createEmpresa();
        Assertions.assertNull(empresa.getCreateUpdateAt());
    }

    @Test
    public void get_id(){
        Empresa empresa = Factory.createEmpresa();
        Assertions.assertNotNull(empresa.getId());
    }
    @Test
    public void get_cnpj(){
        Empresa empresa = Factory.createEmpresa();
        Assertions.assertNotNull(empresa.getCnpj());
    }
    @Test
    public void get_razao_social(){
        Empresa empresa = Factory.createEmpresa();
        Assertions.assertNotNull(empresa.getRazaoSocial());
    }
    @Test
    public void get_contrato_estabelecido(){
        Empresa empresa = Factory.createEmpresa();
        Assertions.assertNotNull(empresa.getContratoEstabelecido());
    }
    @Test
    public void get_email_estabelecido(){
        Empresa empresa = Factory.createEmpresa();
        Assertions.assertNotNull(empresa.getEmailEstabelecido());
    }
    @Test
    public void get_cpf(){
        Empresa empresa = Factory.createEmpresa();
        Assertions.assertNotNull(empresa.getCpf());
    }
    @Test
    public void get_mcc(){
        Empresa empresa = Factory.createEmpresa();
        Assertions.assertNotNull(empresa.getMcc());
    }

    @Test
    public void set_id(){
        Empresa empresa = Factory.createEmpresa();
        empresa.setId(2l);
        Assertions.assertEquals(2l,empresa.getId());
    }
    @Test
    public void set_cnpj(){
        coringa ="12345678910123";
        Empresa empresa = Factory.createEmpresa();
        empresa.setCnpj(coringa);
        Assertions.assertEquals(coringa,empresa.getCnpj());
    }
    @Test
    public void set_cpf(){
        Empresa empresa = Factory.createEmpresa();
        coringa ="12345678910";
        empresa.setCpf(coringa);
        Assertions.assertEquals(coringa,empresa.getCpf());
    }
    @Test
    public void set_mcc(){
        coringa ="1234";
        Empresa empresa = Factory.createEmpresa();
        empresa.setMcc(coringa);
        Assertions.assertEquals(coringa,empresa.getMcc());
    }
    @Test
    public void set_razao_social(){
        coringa = "nome teste";
        Empresa empresa = Factory.createEmpresa();
        empresa.setRazaoSocial(coringa);
        Assertions.assertEquals(coringa,empresa.getRazaoSocial());
    }
    @Test
    public void set_contrato_estabelecido(){
        coringa = "contrato teste";
        Empresa empresa = Factory.createEmpresa();
        empresa.setContratoEstabelecido(coringa);
        Assertions.assertEquals(coringa,empresa.getContratoEstabelecido());
    }
    @Test
    public void set_email_estabelecido(){
        coringa = "empresa@gmail.com";
        Empresa empresa = Factory.createEmpresa();
        empresa.setEmailEstabelecido(coringa);
        Assertions.assertEquals(coringa,empresa.getEmailEstabelecido());
    }


}
