package br.com.cielo.bootcampdesafio01.domain.repository;

import br.com.cielo.bootcampdesafio01.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente,Long> {

    Cliente findByCpf(String cpf);

}
