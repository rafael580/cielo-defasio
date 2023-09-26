package br.com.cielo.bootcampdesafio01.domain.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
@MappedSuperclass
@Data
public sealed class Usuario permits Cliente,Empresa{


    private Integer mcc;
    private String cpf;


    public Usuario() {
    }

    public Usuario(Integer mcc, String cpf) {
        this.mcc = mcc;
        this.cpf = cpf;
    }
}
