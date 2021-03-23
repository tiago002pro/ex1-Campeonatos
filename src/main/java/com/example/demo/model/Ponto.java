package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Ponto implements Comparable<Ponto> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_time", referencedColumnName = "id")
    private Time time;

    @Column(name = "pontuacao")
    private Integer pontuacao;

    @Override
    public int compareTo(Ponto ponto) {
        return this.pontuacao.compareTo(ponto.pontuacao);
    }
}
