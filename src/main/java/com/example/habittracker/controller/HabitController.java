package com.example.habittracker.controller;

import com.example.habittracker.model.Habit;
import com.example.habittracker.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/habits")
public class HabitController {
    @Autowired
    private HabitService habitService;

    @PostMapping
    public ResponseEntity<Habit> addHabit(@RequestBody Habit habit) {
        return ResponseEntity.status(201).body(habitService.addHabit(habit));
    }

    @GetMapping
    public List<Habit> listHabits() {
        return habitService.listHabits();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habit> updateHabit(@PathVariable Long id, @RequestBody Habit habit) {
        return ResponseEntity.ok(habitService.updateHabit(id, habit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabit(@PathVariable Long id) {
        habitService.deleteHabit(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/summary")
    public Map<String, Object> getSummary() {
        return habitService.getSummary();
    }
}
