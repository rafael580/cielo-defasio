package br.com.cielo.bootcampdesafio01.api.service.validation.cliente;

import br.com.cielo.bootcampdesafio01.api.controller.exception.FieldMessage;
import br.com.cielo.bootcampdesafio01.domain.entity.Cliente;
import br.com.cielo.bootcampdesafio01.domain.entity.Empresa;
import br.com.cielo.bootcampdesafio01.domain.repository.ClienteRepository;
import br.com.cielo.bootcampdesafio01.dto.filters.cliente.ClienteUpdateDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClienteUpdateValidator  implements ConstraintValidator<ClienteUpdateValid, ClienteUpdateDTO> {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ClienteRepository repository;

    @Override
    public void initialize(ClienteUpdateValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(ClienteUpdateDTO clienteUpdateDTO, ConstraintValidatorContext constraintValidatorContext) {

        var uriVars =  (Map<String,String>)   request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Long clienteId = Long.parseLong( uriVars.get("id"));
        List<FieldMessage> list = new ArrayList<>();

        Cliente cliente = repository.findByCpf(clienteUpdateDTO.getCpf());

        if(cliente!=null && clienteId != cliente.getId()){
            list.add(new FieldMessage("cpf","cpf existente"));
        }


        for (FieldMessage e : list) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
