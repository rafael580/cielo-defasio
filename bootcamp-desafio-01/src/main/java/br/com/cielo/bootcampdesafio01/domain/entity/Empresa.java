package br.com.cielo.bootcampdesafio01.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_empresa")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper=false)

public final class Empresa extends Usuario implements Serializable {

        private static final Long serialVersionUID = 1L;

        @Id
        @Column(name = "id", nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String cnpj;
        private String razaoSocial;
        private String contratoEstabelecido;
        private String emailEstabelecido;
        @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
        private Instant createdAt;
        @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
        private Instant createdUpdateAt;

        public Empresa(){}


    public Empresa(Long id,String cnpj, String razaoSocial, String mcc, String cpf, String contratoEstabelecido, String emailEstabelecido) {

            super(mcc,cpf);
            this.id = id;
            this.cnpj = cnpj;
            this.razaoSocial = razaoSocial;
            this.contratoEstabelecido = contratoEstabelecido;
            this.emailEstabelecido = emailEstabelecido;
    }

    public Instant getCreateAt() {
        return createdAt;
    }

    public Instant getCreateUpdateAt() {
        return createdUpdateAt;
    }

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        createdUpdateAt = Instant.now();
    }


}
