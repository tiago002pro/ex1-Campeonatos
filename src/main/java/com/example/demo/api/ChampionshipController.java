package com.example.demo.api;

import com.example.demo.model.Championship;
import com.example.demo.model.Score;
import com.example.demo.service.ChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ChampionshipController {

    @Autowired
    private ChampionshipService service;

    @PostMapping("/campeonatos")
    public Championship createChampionship(@RequestBody Map<String, String> json) {
        return this.service.createChampionship(json);
    }

    @GetMapping("/campeonatos")
    public List<Championship> getChampionships(){
        return this.service.getChampionships();
    }

    @GetMapping("campeonatos/{id}")
    public Championship getChampionship(@PathVariable Integer id) {
        return this.service.getChampionships().get(id);
    }

    @PostMapping("/insere")
    public void insertTeamChampionship(@RequestBody Map<String, Integer> json) {
        this.service.insertTeamChampionship(json);
    }

    @GetMapping("/insere/campeonato/{id}")
    public List<Score> getScore(@PathVariable Integer id) {
        return this.service.getScore(id);
    }

    @GetMapping("/insere/campeonato/tabelapontos")
    public List<Championship> getScoreboard() {
        return this.service.getScoreboard();
    }

}
