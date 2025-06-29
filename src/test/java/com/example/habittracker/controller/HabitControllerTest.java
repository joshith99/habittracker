package com.example.habittracker.controller;

import com.example.habittracker.model.Habit;
import com.example.habittracker.service.HabitService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HabitController.class)
public class HabitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HabitService habitService;

    @Test
    public void testAddHabit() throws Exception {
        Habit habit = new Habit("Drink Water", "Drink 2L daily");
        when(habitService.addHabit(any(Habit.class))).thenReturn(habit);

        mockMvc.perform(post("/habits")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Drink Water\",\"description\":\"Drink 2L daily\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Drink Water"));
    }

    @Test
    public void testListHabits() throws Exception {
        List<Habit> habits = List.of(new Habit("Read", "Read 20 pages"));
        when(habitService.listHabits()).thenReturn(habits);

        mockMvc.perform(get("/habits"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Read"));
    }

    @Test
    public void testUpdateHabit() throws Exception {
        Habit updated = new Habit("Exercise", "30 mins");
        when(habitService.updateHabit(Mockito.eq(1L), any(Habit.class))).thenReturn(updated);

        mockMvc.perform(put("/habits/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Exercise\",\"description\":\"30 mins\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Exercise"));
    }

    @Test
    public void testDeleteHabit() throws Exception {
        mockMvc.perform(delete("/habits/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testGetSummary() throws Exception {
        Map<String, Object> summary = Map.of("totalHabits", 2, "activeStreaks", 1);
        when(habitService.getSummary()).thenReturn(summary);

        mockMvc.perform(get("/habits/summary"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalHabits").value(2));
    }
}
