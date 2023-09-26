package br.com.cielo.bootcampdesafio02.api.service;


import br.com.cielo.bootcampdesafio02.api.service.exceptions.DataBaseException;
import br.com.cielo.bootcampdesafio02.api.service.exceptions.EntityNotFound;
import br.com.cielo.bootcampdesafio02.domain.entity.Empresa;
import br.com.cielo.bootcampdesafio02.domain.repository.EmpresaRepository;
import br.com.cielo.bootcampdesafio02.dto.EmpresaDTO;
import br.com.cielo.bootcampdesafio02.dto.filters.empresa.EmpresaInsertDTO;
import br.com.cielo.bootcampdesafio02.dto.filters.empresa.EmpresaUpdateDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Transactional
    public Page<EmpresaDTO> findAllPaged(Pageable pageAble){
        Page<Empresa> obj = repository.findAll( pageAble);
        return obj.map(x-> new EmpresaDTO(x));
    }

    @Transactional
    public EmpresaDTO findById(Long id){
        Optional<Empresa> empresa = repository.findById(id);
        Empresa empresaRecebe = empresa.orElseThrow(()->{
            throw new EntityNotFound("Entity not found");
        });
        return new EmpresaDTO(empresaRecebe);
    }
    @Transactional
    public EmpresaDTO insert(EmpresaInsertDTO dto){
        Empresa empresa = new Empresa();
        copyDtoToEntity(dto,empresa);
        empresa =  repository.save(empresa);
        return  new EmpresaDTO(empresa);
    }

    @Transactional
    public EmpresaDTO update(Long id, EmpresaUpdateDTO dto){
        try {
            Empresa empresa = repository.getOne(id);
            copyDtoToEntity(dto,empresa);
            empresa = repository.save(empresa);
            return new EmpresaDTO(empresa);
        }
        catch (EntityNotFoundException e){
            throw new EntityNotFound("Id not found" + id);
        }
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFound("Id not found" + id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataBaseException("Integrety violation");
        }
    }

    private void copyDtoToEntity(EmpresaDTO dto, Empresa pro){
        pro.setEmailEstabelecido(dto.getEmailEstabelecido());
        pro.setCnpj(dto.getCnpj());
        pro.setCpf(dto.getCpf());
        pro.setMcc(dto.getMcc());
        pro.setContratoEstabelecido(dto.getContratoEstabelecido());
        pro.setRazaoSocial(dto.getRazaoSocial());

    }

}
