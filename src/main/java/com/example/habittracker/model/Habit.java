package com.example.habittracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int streak;
    private LocalDate lastCompleted;

    public Habit() {}

    public Habit(String name, String description) {
        this.name = name;
        this.description = description;
        this.streak = 0;
        this.lastCompleted = null;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getStreak() { return streak; }
    public void setStreak(int streak) { this.streak = streak; }
    public LocalDate getLastCompleted() { return lastCompleted; }
    public void setLastCompleted(LocalDate lastCompleted) { this.lastCompleted = lastCompleted; }
}
