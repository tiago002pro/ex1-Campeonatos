package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Campeonato {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "nome")
        private String nome;

        @Column(name = "data_inicial")
        private Date dataInicial;

        @Column(name = "data_final")
        private Date dataFinal;

        @OneToMany(cascade = CascadeType.MERGE)
        @JoinColumn(name = "id_campeonato", referencedColumnName = "id")
        private List<Ponto> tabela;
}
