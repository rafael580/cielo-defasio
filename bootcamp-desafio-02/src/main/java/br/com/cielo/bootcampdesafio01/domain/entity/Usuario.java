package br.com.cielo.bootcampdesafio02.domain.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
@MappedSuperclass
@Data
public sealed class Usuario permits Cliente,Empresa{


    private String mcc;
    private String cpf;


    public Usuario() {
    }

    public Usuario(String mcc, String cpf) {
        this.mcc = mcc;
        this.cpf = cpf;
    }
}
