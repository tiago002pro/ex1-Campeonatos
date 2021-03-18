package com.example.demo.api;

import com.example.demo.model.Campeonato;
import com.example.demo.model.Ponto;
import com.example.demo.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CampeonatoController {

    @Autowired
        private CampeonatoService service;

    @PostMapping("/campeonatos")
    public String criaCampeonato(@RequestBody Map<String, Object> json) {
        return this.service.criaCampeonato(json);
    }

    @GetMapping("/campeonatos")
    public List<Campeonato> getChampionships(){
        return this.service.pegaCampeonatos();
    }

    @PostMapping("/campeonato/{id}/insere-time")
    public String insereTimeNoCampeonato(@PathVariable Integer id, @RequestBody Map<String, Integer> json) {
        return this.service.insereTimeNoCampeonato(id, json);
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
