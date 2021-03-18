package com.example.demo.model;

import java.util.Date;
import java.util.List;

public class Campeonato {
        private String nome;
        private Date dataInicial;
        private Date dataFinal;
        private List<Ponto> tabela;

        public String getNome() {
                return nome;
        }
        public void setNome(String nome) {
                this.nome = nome;
        }
        public Date getDataInicial() {
                return dataInicial;
        }
        public void setDataInicial(Date dataInicial) {
                this.dataInicial = dataInicial;
        }
        public Date getDataFinal() {
                return dataFinal;
        }
        public void setDataFinal(Date dataFinal) {
                this.dataFinal = dataFinal;
        }
        public List<Ponto> getTabela() {
                return tabela;
        }
        public void setTabela(List<Ponto> tabela) {
                this.tabela = tabela;
        }
}
