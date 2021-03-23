package com.example.demo.api;

import com.example.demo.model.Campeonato;
import com.example.demo.model.Ponto;
import com.example.demo.model.Time;
import com.example.demo.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
public class CampeonatoController {

    @Autowired
        private CampeonatoService service;

    @PostMapping("/campeonatos")
    public String criaCampeonato(@RequestBody Map<String, String> json) throws ParseException {
        return this.service.criaCampeonato(json);
    }

    @GetMapping("/campeonatos")
    public List<Campeonato> getChampionships(){
        return this.service.pegaCampeonatos();
    }

    @GetMapping("campeonato/{id}")
    public Campeonato pegaTime(@PathVariable Long id) {
        return this.service.pegaCampeonatos().get(Math.toIntExact(id));
    }

    @PostMapping("/campeonato/{id_campeonato}/insere-time/{id_time}")
    public String insereTimeNoCampeonato(@PathVariable Long id_campeonato, @PathVariable Long id_time, @RequestBody Map<String, Long> json) {
        return this.service.insereTimeNoCampeonato(id_campeonato, id_time, json);
    }

//    @GetMapping("/insere/campeonato/{id}")
//    public List<Ponto> getScore(@PathVariable Integer id) {
//        return this.service.getScore(id);
//    }
//
//    @GetMapping("/insere/campeonato/tabelapontos")
//    public List<Campeonato> getScoreboard() {
//        return this.service.getScoreboard();
//    }

}
