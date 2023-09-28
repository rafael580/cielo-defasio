package br.com.cielo.bootcampdesafio04.api.service.validation.empresa;

import br.com.cielo.bootcampdesafio04.api.controller.exception.FieldMessage;
import br.com.cielo.bootcampdesafio04.domain.entity.Empresa;
import br.com.cielo.bootcampdesafio04.domain.repository.EmpresaRepository;
import br.com.cielo.bootcampdesafio04.dto.filters.empresa.EmpresaInsertDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EmpresaInsertValidator implements ConstraintValidator<EmpresaInsertValid, EmpresaInsertDTO> {

    @Autowired
    private EmpresaRepository repository;


    @Override
    public void initialize(EmpresaInsertValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(EmpresaInsertDTO empresaInsertDTO, ConstraintValidatorContext constraintValidatorContext) {

        List<FieldMessage> list = new ArrayList<>();

        Empresa empresa = repository.findByCnpj(empresaInsertDTO.getCnpj());
        if(empresa!=null){
            list.add(new FieldMessage("cnpj","cnpj existente"));
        }
        empresa = repository.findByEmailEstabelecido(empresaInsertDTO.getEmailEstabelecido());
        if(empresa!=null){
            list.add(new FieldMessage("emailEstabelecido","email existente"));
        }
        empresa = repository.findByCpf(empresaInsertDTO.getCpf());
        if(empresa!=null){
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
