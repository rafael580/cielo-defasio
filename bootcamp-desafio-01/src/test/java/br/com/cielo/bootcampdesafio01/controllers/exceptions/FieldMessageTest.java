package br.com.cielo.bootcampdesafio01.controllers.exceptions;

import br.com.cielo.bootcampdesafio01.api.controller.exception.FieldMessage;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FieldMessageTest {


    @Test
    public void fieldMessage_exist(){
        FieldMessage fieldMessage = new FieldMessage();
        Assertions.assertNotNull(fieldMessage);
    }

    @Test
    public void fieldMessage_constructor_exist(){
        FieldMessage fieldMessage = new FieldMessage("nome teste","mensagem teste");
        Assertions.assertNotNull(fieldMessage);
    }

    @Test
    public void get_fildName(){
        FieldMessage fieldMessage = new FieldMessage("nome teste","mensagem teste");
        Assertions.assertNotNull(fieldMessage.getFieldName());
    }

    @Test
    public void get_message(){
        FieldMessage fieldMessage = new FieldMessage("nome teste","mensagem teste");
        Assertions.assertNotNull(fieldMessage.getMessage());
    }
    @Test
    public void set_fildName(){
        FieldMessage fieldMessage = new FieldMessage("nome teste","mensagem teste");
        fieldMessage.setFieldName("nada");
        Assertions.assertNotNull(fieldMessage.getFieldName());
    }

    @Test
    public void set_message(){
        FieldMessage fieldMessage = new FieldMessage("nome teste","mensagem teste");
        fieldMessage.setMessage("nada");
        Assertions.assertNotNull(fieldMessage.getMessage());
    }


}
