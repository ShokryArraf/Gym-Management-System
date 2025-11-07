package com.example.Gym.Management.System.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutPlanDto {
    private Long id;
    private String name;
    private String description;
    private int difficulty;

    public WorkoutPlanDto(Long id, String name, String description, int difficulty) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
    }
    public WorkoutPlanDto() {}
}
