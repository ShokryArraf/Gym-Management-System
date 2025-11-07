package com.example.Gym.Management.System.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutPlanCreateDto {
    @NotBlank
    @Size(min = 2, max = 50)
    private String name;
    @NotBlank
    private String description;
    @Min(value = 1, message = "Difficulty must be at least 1")
    @Max(value = 5, message = "Difficulty cannot be more than 5")
    private int difficulty;
}
