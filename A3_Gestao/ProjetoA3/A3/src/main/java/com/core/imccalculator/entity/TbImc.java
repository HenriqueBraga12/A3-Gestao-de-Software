package com.core.imccalculator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "tb_imc")
public class TbImc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "imc")
    private Double imc;

    @Column(name = "classificacao")
    private String classificacao;


}
