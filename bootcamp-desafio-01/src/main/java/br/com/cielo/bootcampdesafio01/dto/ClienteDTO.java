package br.com.cielo.bootcampdesafio01.dto;

import br.com.cielo.bootcampdesafio01.domain.entity.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClienteDTO implements Serializable {

    private static final Long serialVersionUID = 1L;


    @EqualsAndHashCode.Include
    private Long id;
    @Size(min = 11,max = 11,message = "minimo 11")
    @NotBlank(message = "cpf requerido")
    private String cpf;

    @Size(min = 0,max = 4,message = "maximo de 4 numeros")
    @NotBlank(message = "mcc requerido")
    private String mcc;
    @Size(min = 0,max = 50,message = "maximo de 50 caracteres")
    @NotBlank(message = "nome requerido")
    private String nome;

    @NotBlank(message = "email requerido")
    @Pattern(regexp="^([a-z]){1,}([a-z0-9._-]){1,}([@]){1}([a-z]){2,}([.]){1}([a-z]){2,}([.]?){1}([a-z]?){2,}$")
    private String email;


    public ClienteDTO() {
    }

    public ClienteDTO( Long id, String cpf, String mcc, String nome, String email) {
        this.id = id;
        this.cpf = cpf;
        this.mcc = mcc;
        this.nome = nome;
        this.email = email;
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.cpf = cliente.getCpf();
        this.mcc = cliente.getMcc();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
    }


}
