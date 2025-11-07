package com.example.Gym.Management.System.controller;

import com.example.Gym.Management.System.dto.WorkoutPlanCreateDto;
import com.example.Gym.Management.System.dto.WorkoutPlanDto;
import com.example.Gym.Management.System.entities.WorkoutPlan;
import com.example.Gym.Management.System.service.WorkoutPlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/plans")
public class WorkoutPlanController {
    private final WorkoutPlanService workoutPlanService;
    //dependency injection
    public WorkoutPlanController(WorkoutPlanService workoutPlanService) {
        this.workoutPlanService = workoutPlanService;
    }

    @GetMapping
    public ResponseEntity<List<WorkoutPlanDto>> getAllDoctors() {
        return ResponseEntity.ok(workoutPlanService.getWorkouts());
    }

    @PostMapping
    public ResponseEntity<WorkoutPlanDto> addWorkoutPlan(@RequestBody WorkoutPlanCreateDto dto) {
        return ResponseEntity.ok(workoutPlanService.createWorkoutPlan(dto));
    }

}
