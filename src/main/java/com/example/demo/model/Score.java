package com.example.demo.model;

public class Score implements Comparable<Score> {
    private Team team;
    private Integer pontuacao;


    public void setTime(Team team) {
        this.team = team;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public int compareTo(Score score) {
        return this.pontuacao.compareTo(score.pontuacao);
    }

}
