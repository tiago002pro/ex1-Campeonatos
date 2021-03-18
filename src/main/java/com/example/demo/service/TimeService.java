package com.example.demo.service;

import com.example.demo.model.Time;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TimeService {

    List<Time> times = new ArrayList<>();

    public String cadastraTime (Map<String, String> json) {
        Time time = new Time();

        time.setNome(json.get("Time"));
        times.add(time);

        return "Time cadastrado com sucesso!";
    }

    public List<Time> pegaListaTimes () {
        return times;
    }

    public Time pegaTime (Integer idTime) {
        return this.times.get(idTime);
    }
}
