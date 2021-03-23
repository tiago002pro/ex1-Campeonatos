package com.example.demo.service;

import com.example.demo.model.Time;
import com.example.demo.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TimeService {

    @Autowired
        TimeRepository repository;

    public String cadastraTime (Map<String, String> json) {
        Time time = new Time();

        time.setNome(json.get("Time"));
        this.repository.save(time);
        return "Time cadastrado com sucesso!";
    }

    public List<Time> pegaListaTimes () {
        return this.repository.findAll();
    }

    public Time pegaTime (Long idTime) {
        return this.repository.findById(idTime).get();
    }
}
