package com.example.demo.model;

public class Ponto implements Comparable<Ponto> {
    private Time time;
    private Integer pontuacao;

    public void setTime(Time time) {
        this.time = time;
    }
    public Time getTime() {
        return time;
    }
    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }
    public Integer getPontuacao() {
        return pontuacao;
    }

    @Override
    public int compareTo(Ponto ponto) {
        return this.pontuacao.compareTo(ponto.pontuacao);
    }
}
