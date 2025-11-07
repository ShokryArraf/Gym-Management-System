package com.example.Gym.Management.System.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TraineeDto {
    private Long id;
    private String name;
    private String email;
    private LocalDate joinDate;
    private Long activePlanId;

    public TraineeDto(Long id, String email, String name, LocalDate joinDate, Long activePlanId) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.joinDate = joinDate;
        this.activePlanId = activePlanId;
    }
    public TraineeDto() {}
}
