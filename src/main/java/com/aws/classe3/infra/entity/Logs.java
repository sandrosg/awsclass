package com.aws.classe3.infra.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@Entity(name = "logs")
public class Logs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="cep",length = 9, nullable = false)
    private String cep;

    @Column(name="data", nullable = false)
    private Date data;

    public Logs(String cep) {
        this.cep = cep;
        this.data = new Date();
    }
}

