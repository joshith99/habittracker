package com.example.habittracker.service;

import com.example.habittracker.model.Habit;
import com.example.habittracker.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HabitService {
    @Autowired
    private HabitRepository habitRepository;

    public Habit addHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    public List<Habit> listHabits() {
        return habitRepository.findAll();
    }

    public Habit updateHabit(Long id, Habit updated) {
        return habitRepository.findById(id)
                .map(habit -> {
                    habit.setName(updated.getName());
                    habit.setDescription(updated.getDescription());
                    habit.setStreak(updated.getStreak());
                    habit.setLastCompleted(updated.getLastCompleted());
                    return habitRepository.save(habit);
                }).orElseThrow(() -> new RuntimeException("Habit not found"));
    }

    public void deleteHabit(Long id) {
        habitRepository.deleteById(id);
    }

    public Map<String, Object> getSummary() {
        List<Habit> habits = habitRepository.findAll();
        int total = habits.size();
        int activeStreaks = (int) habits.stream().filter(h -> h.getStreak() > 0).count();
        return Map.of("totalHabits", total, "activeStreaks", activeStreaks);
    }
}
