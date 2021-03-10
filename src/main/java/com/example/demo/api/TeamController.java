package com.example.demo.api;

import com.example.demo.model.Team;
import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TeamController {
        @Autowired
        private TeamService service;

        @GetMapping("/times")
        public List<Team> getTimes() {
            return this.service.getTimes();
        }

        @PostMapping("/times")
        public Team createTime(@RequestBody Map<String, String> json) {
            this.service.createTime(json);
            return this.service.getTimes().get(this.service.getTimes().size()-1);
        }

        @GetMapping("times/{id}")
        public Team getTimes(@PathVariable Long id) {
            return this.service.getTimes().get(Math.toIntExact(id));
        }
}
