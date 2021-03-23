package com.example.demo.service;

import com.example.demo.model.Campeonato;
import com.example.demo.model.Ponto;
import com.example.demo.model.Time;
import com.example.demo.repository.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.*;

@Service
public class CampeonatoService {

    @Autowired
        CampeonatoRepository repository;
    @Autowired
        TimeService timeService;

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    Random random = new Random();

    public String criaCampeonato (Map<String, String> json) throws ParseException {
        Campeonato campeonato = new Campeonato();

        campeonato.setNome(json.get("Campeonato"));
        campeonato.setDataInicial(format.parse(json.get("Data-inicio")));
        campeonato.setDataFinal(format.parse(json.get("Data-fim")));
        this.repository.save(campeonato);
        return "Campeonato criado com sucesso!";
    }

    public List<Campeonato> pegaCampeonatos () {
        return this.repository.findAll();
    }

    public String insereTimeNoCampeonato(Long idCampeonato, Long idTIme, Map<String, Long> json) {
        Campeonato campeonato = this.pegaCampeonato(idCampeonato);
        Time time = this.timeService.pegaTime(idTIme);
        Ponto ponto = new Ponto();

        ponto.setTime(time);
        ponto.setPontuacao(new Random().nextInt(15));
        campeonato.getTabela().add(ponto);
        this.repository.save(campeonato);
        return "Time entrou no campeonato";
    }

    public Campeonato pegaCampeonato (Long idCampeonato) {
        return this.repository.findById(idCampeonato).get();
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
