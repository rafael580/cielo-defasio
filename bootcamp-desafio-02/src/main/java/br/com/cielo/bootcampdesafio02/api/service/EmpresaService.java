package br.com.cielo.bootcampdesafio02.api.service;


import br.com.cielo.bootcampdesafio02.api.service.exceptions.EntityNotFound;
import br.com.cielo.bootcampdesafio02.data_structure.Fila;
import br.com.cielo.bootcampdesafio02.domain.entity.Empresa;
import br.com.cielo.bootcampdesafio02.domain.repository.EmpresaRepository;
import br.com.cielo.bootcampdesafio02.dto.EmpresaDTO;
import br.com.cielo.bootcampdesafio02.dto.filters.empresa.EmpresaInsertDTO;
import br.com.cielo.bootcampdesafio02.dto.filters.empresa.EmpresaUpdateDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService {


    Fila<EmpresaDTO> empresaDTOFila = new Fila<>();


    @Autowired
    private EmpresaRepository repository;

    //FILA DE EMPRESAS
    public Fila<EmpresaDTO> filaEmpresas(){
        return this.empresaDTOFila;
    }


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

        EmpresaDTO empresaDTO =  new EmpresaDTO(empresa);
        empresaDTOFila.inserir(empresaDTO);
        return empresaDTO;
    }

    @Transactional
    public EmpresaDTO update(Long id, EmpresaUpdateDTO dto){
        try {
            Empresa empresa = repository.getOne(id);
            copyDtoToEntity(dto,empresa);
            empresa = repository.save(empresa);
            EmpresaDTO empresaDTO =  new EmpresaDTO(empresa);
            empresaDTOFila.atualizar(empresaDTO);
            return empresaDTO;
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
