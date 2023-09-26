package br.com.cielo.bootcampdesafio01.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_cliente")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper=false)
public final class Cliente extends Usuario implements Serializable {

    private static final Long serialVersionUID = 1L;


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdUpdateAt;


    public Cliente(){}


    public Cliente(Long id,String cpf, String mcc, String nome, String email) {

        super(mcc,cpf);
        this.id = id;
        this.nome = nome;
        this.email = email;
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
