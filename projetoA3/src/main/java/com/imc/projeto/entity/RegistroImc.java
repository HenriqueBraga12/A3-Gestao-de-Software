package com.imc.projeto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "tb_registro_imc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroImc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private Usuario usuario;

    @Column(name = "imc")
    private Double imc;

    @Column(name = "classificacao")
    private String classificacao;

    @Column(name = "data_registro")
    private Date dataRegistro;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "altura")
    private Double altura;
}
