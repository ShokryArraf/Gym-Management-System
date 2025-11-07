package com.example.Gym.Management.System.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutPlan {
    private Long id;
    private String name;
    private String description;
    private int difficulty;

    public WorkoutPlan(Long id, int difficulty, String description, String name) {
        this.id = id;
        this.difficulty = difficulty;
        this.description = description;
        this.name = name;
    }
}
