package com.example.Gym.Management.System.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Trainee {
    private Long id;
    private String name;
    private String email;
    private LocalDate joinDate;
    private Long activePlanId;

    public Trainee(String name, String email, LocalDate joinDate, Long activePlanId, Long id) {
        this.name = name;
        this.email = email;
        this.joinDate = joinDate;
        this.activePlanId = activePlanId;
        this.id = id;
    }
}
