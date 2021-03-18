package com.example.demo.service;

import com.example.demo.model.Campeonato;
import com.example.demo.model.Ponto;
import com.example.demo.model.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;
import java.util.*;

@Service
public class CampeonatoService {

    @Autowired
        TimeService timeService;

    List<Campeonato> campeonatos = new ArrayList<>();
    Random random = new Random();

    public String criaCampeonato (Map<String, Object> json) {
        Campeonato campeonato = new Campeonato();

        campeonato.setNome((String) json.get("Campeonato"));
        campeonato.setDataInicial((Date) json.get("Data-inicio"));
        campeonato.setDataFinal((Date) (json.get("Data-fim")));
        campeonato.setTabela(new ArrayList<Ponto>());
        campeonatos.add(campeonato);

        return "Campeonato criado com sucesso!";
    }

    public List<Campeonato> pegaCampeonatos () {
        return campeonatos;
    }

    public String insereTimeNoCampeonato(Integer idCampeonato, Map<String, Integer> json) {
        List<Ponto> insereTime = campeonatos.get(idCampeonato).getTabela();
        Time time = timeService.times.get(json.get("idTime"));
        Ponto ponto = new Ponto();

        ponto.setTime(time);
        ponto.setPontuacao(new Random().nextInt(15));
        insereTime.add(ponto);

        return "Time entrou no campeonato";
    }

//    public List<Ponto> getScore (Integer id) {
//        Collections.sort(campeonatos.get(id).getTabela(), Collections.reverseOrder());
//        return campeonatos.get(id).getTabela();
//    }
//
//   public List<Campeonato> getScoreboard () {
//       int size = campeonatos.size();
//       for(int x=0; x<size; x++) {
//                getScore(x);
//       }
//       return campeonatos;
//   }
}
