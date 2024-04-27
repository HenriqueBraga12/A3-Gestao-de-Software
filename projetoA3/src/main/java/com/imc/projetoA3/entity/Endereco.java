package com.imc.projetoA3.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_endereco")
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEndereco;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Usuario dataUser;

    @Column(name = "cep")
    private String cep;

    @Column(name = "logradouro")
    private String logradouro;

    @Column (name = "complemento")
    private String complemento;
}
