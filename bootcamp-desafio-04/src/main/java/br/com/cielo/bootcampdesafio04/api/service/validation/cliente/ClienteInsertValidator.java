package br.com.cielo.bootcampdesafio04.api.service.validation.cliente;

import br.com.cielo.bootcampdesafio04.api.controller.exception.FieldMessage;
import br.com.cielo.bootcampdesafio04.domain.entity.Cliente;
import br.com.cielo.bootcampdesafio04.domain.repository.ClienteRepository;
import br.com.cielo.bootcampdesafio04.dto.filters.cliente.ClienteInsertDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsertValid, ClienteInsertDTO> {

    @Autowired
    private ClienteRepository repository;


    @Override
    public void initialize(ClienteInsertValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(ClienteInsertDTO clienteInsertDTO, ConstraintValidatorContext constraintValidatorContext) {
        List<FieldMessage> list = new ArrayList<>();

        Cliente cliente = repository.findByCpf(clienteInsertDTO.getCpf());
        if(cliente!=null){
            list.add(new FieldMessage("cpf","cpf existente"));
        }
        cliente = repository.findByEmail(clienteInsertDTO.getEmail());
        if(cliente!=null){
            list.add(new FieldMessage("email","email existente"));
        }
        for (FieldMessage e : list) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }

}
