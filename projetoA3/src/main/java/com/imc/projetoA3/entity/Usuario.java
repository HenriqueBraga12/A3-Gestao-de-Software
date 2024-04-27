package com.imc.projetoA3.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("user_id")
    private Long idUsuario;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_cpf")
    private String cpf;

    @OneToOne(mappedBy = "dataUser", cascade = CascadeType.ALL)
    private Endereco endereco;

    @Column(name = "peso")
    private Double peso;

    @Column (name = "altura")
    private Double altura;

}
