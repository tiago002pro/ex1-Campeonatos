package com.example.demo.service;

import com.example.demo.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TeamService {

    List<Team> teams = new ArrayList<>();

    public List<Team> getTimes() {
        return teams;
    }

    public Team getTime(Integer idTime) {
        return this.teams.get(idTime);
    }

    public Team createTime(Map<String, String> json) {
        Team time = new Team();
        time.setName(json.get("nomeDoTime"));
        teams.add(time);
        return time;
    }


}
