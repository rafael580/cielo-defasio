package br.com.cielo.bootcampdesafio03.api.service;

import br.com.cielo.bootcampdesafio03.api.service.exceptions.DataBaseException;
import br.com.cielo.bootcampdesafio03.api.service.exceptions.EntityNotFound;
import br.com.cielo.bootcampdesafio03.data_structure.Fila;
import br.com.cielo.bootcampdesafio03.domain.entity.Cliente;
import br.com.cielo.bootcampdesafio03.domain.repository.ClienteRepository;

import br.com.cielo.bootcampdesafio03.dto.ClienteDTO;
import br.com.cielo.bootcampdesafio03.dto.filters.cliente.ClienteInsertDTO;
import br.com.cielo.bootcampdesafio03.dto.filters.cliente.ClienteUpdateDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {



    Fila<ClienteDTO> clienteDTOFila = new Fila<>();

    @Autowired
    private ClienteRepository repository;


    //FILA DE CLIENTES
    public Fila<ClienteDTO> filaClientes(){
        return this.clienteDTOFila;
    }

    public Page<ClienteDTO> findAllPaged(Pageable pageAble){
        Page<Cliente> obj = repository.findAll( pageAble);
        return obj.map(x-> new ClienteDTO(x));
    }

    @Transactional
    public ClienteDTO findById(Long id){
        Optional<Cliente> cliente = repository.findById(id);
        Cliente recebeCliente = cliente.orElseThrow(()->{
            throw new EntityNotFound("Entity not found");
        });
        return new ClienteDTO(recebeCliente);
    }
    @Transactional
    public ClienteDTO insert(ClienteInsertDTO dto){
        Cliente cliente = new Cliente();
        copyDtoToEntity(dto,cliente);
        cliente =  repository.save(cliente);
        ClienteDTO clienteDTO =  new ClienteDTO(cliente);
        clienteDTOFila.inserir(clienteDTO);
        return clienteDTO;
    }

    @Transactional
    public ClienteDTO update(Long id, ClienteUpdateDTO dto){
        try {
            Cliente cliente = repository.getOne(id);
            copyDtoToEntity(dto,cliente);
            cliente = repository.save(cliente);
            ClienteDTO clienteDTO  =  new ClienteDTO(cliente);
            clienteDTOFila.atualizar(clienteDTO);
            return clienteDTO;
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

    private void copyDtoToEntity(ClienteDTO dto, Cliente pro){
        pro.setNome(dto.getNome());
        pro.setCpf(dto.getCpf());
        pro.setMcc(dto.getMcc());
        pro.setEmail(dto.getEmail());
    }

}
