package br.com.cielo.bootcampdesafio02.api.service.validation.empresa;

import br.com.cielo.bootcampdesafio02.api.controller.exception.FieldMessage;
import br.com.cielo.bootcampdesafio02.domain.entity.Empresa;
import br.com.cielo.bootcampdesafio02.domain.repository.EmpresaRepository;
import br.com.cielo.bootcampdesafio02.dto.filters.empresa.EmpresaUpdateDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmpresaUpdateValidator implements ConstraintValidator<EmpresaUpdateValid, EmpresaUpdateDTO> {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private EmpresaRepository repository;


    @Override
    public void initialize(EmpresaUpdateValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(EmpresaUpdateDTO empresaUpdateValidator, ConstraintValidatorContext constraintValidatorContext) {
        @SuppressWarnings("unchecked")
        var uriVars =  (Map<String,String>)   request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Long empresaId = Long.parseLong( uriVars.get("id"));
        List<FieldMessage> list = new ArrayList<>();


        Empresa empresa = repository.findByCnpj(empresaUpdateValidator.getCnpj());

        if(empresa!=null && empresaId != empresa.getId()){
            list.add(new FieldMessage("cnpj","cnpj existente"));
        }


        for (FieldMessage e : list) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();

    }
}
