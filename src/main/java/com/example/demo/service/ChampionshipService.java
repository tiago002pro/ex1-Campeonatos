package com.example.demo.service;

import com.example.demo.model.Championship;
import com.example.demo.model.Score;
import com.example.demo.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;
import java.util.*;

@Service
public class ChampionshipService {

    @Autowired
    TeamService teamService;

    List<Championship> championships = new ArrayList<>();
    Random gerador = new Random();

    public Championship createChampionship(Map<String, String> json) {
        Championship c = new Championship();
        c.setName(json.get("nomeDoCampeonato"));
        c.setInitialDate(new Date(json.get("dataInicio")));
        c.setFinalDate(new Date(json.get("dataFim")));
        c.setTable(new ArrayList<Score>());
        championships.add(c);
        return c;
    }

    public List<Championship> getChampionships() {
        return championships;
    }

    public void insertTeamChampionship(Map<String, Integer> json) {
        List<Score> teamInTheChampionship = championships.get(json.get("idCampeonato")).getTable();
        Team team = teamService.getTime(json.get("idTime"));
        Score score = new Score();
        score.setTime(team);
        score.setPontuacao(new Random().nextInt(50));
        teamInTheChampionship.add(score);
    }

    public List<Score> getScore(Integer id) {
        Collections.sort(championships.get(id).getTable(), Collections.reverseOrder());
        return championships.get(id).getTable();
    }

   public List<Championship> getScoreboard() {
       int size = championships.size();
       for(int x=0; x<size; x++) {
                getScore(x);
       }
       return championships;
   }
}
