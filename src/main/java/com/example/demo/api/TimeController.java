package com.example.demo.api;

import com.example.demo.model.Time;
import com.example.demo.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TimeController {

        @Autowired
            private TimeService service;

        @PostMapping("/times")
        public String createTime(@RequestBody Map<String, String> json) {
            return this.service.cadastraTime(json);
        }

        @GetMapping("/times")
        public List<Time> pegaListaTimes() {
            return this.service.pegaListaTimes();
        }

        @GetMapping("times/{id}")
        public Time pegaTime(@PathVariable Long id) {
            return this.service.pegaListaTimes().get(Math.toIntExact(id));
        }
}
