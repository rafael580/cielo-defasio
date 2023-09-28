package br.com.cielo.bootcampdesafio04.domain.repository;


import br.com.cielo.bootcampdesafio04.domain.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long> {

    Empresa findByCnpj(String cnpj);

    Empresa findByEmailEstabelecido(String email);

    Empresa findByCpf(String cpf);
}
