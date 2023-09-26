package br.com.cielo.bootcampdesafio01.dto;

import br.com.cielo.bootcampdesafio01.domain.entity.Empresa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmpresaDTO implements Serializable {

    private static final Long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    private Long id;
    @Size(min = 14,max = 14,message = "minimo 14")
    @NotBlank(message = "cnpj requerido")
    private String cnpj;
    @Size(min = 0,max = 50,message = "maximo de 50 caracteres")
    @NotBlank(message = "razao social requerido")
    private String razaoSocial;
    @Size(min = 0,max = 4,message = "maximo de 4 caracteres")
    @NotBlank(message = "mcc requerido")
    private String mcc;
    @Size(min = 11,max = 11,message = "minimo 11")
    @NotBlank(message = "cpf requerido")
    private String cpf;
    @Size(min = 0,max = 50,message = "maximo de 50 caracteres")
    @NotBlank(message = "contrato estabelecido requerido")
    private String contratoEstabelecido;
    @Pattern(regexp="/^([a-z]){1,}([a-z0-9._-]){1,}([@]){1}([a-z]){2,}([.]){1}([a-z]){2,}([.]?){1}([a-z]?){2,}$/i")
    @NotBlank(message = "email requerido")
    private String emailEstabelecido;

    public EmpresaDTO(){}

    public EmpresaDTO(Long id, String cnpj, String razaoSocial, String mcc, String cpf, String contratoEstabelecido, String emailEstabelecido) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.mcc = mcc;
        this.cpf = cpf;
        this.contratoEstabelecido = contratoEstabelecido;
        this.emailEstabelecido = emailEstabelecido;
    }

    public EmpresaDTO(Empresa empresa) {
        this.id = empresa.getId();
        this.cnpj = empresa.getCnpj();
        this.razaoSocial = empresa.getRazaoSocial();
        this.mcc = empresa.getMcc();
        this.cpf = empresa.getCpf();
        this.contratoEstabelecido = empresa.getContratoEstabelecido();
        this.emailEstabelecido = empresa.getEmailEstabelecido();
    }
}
