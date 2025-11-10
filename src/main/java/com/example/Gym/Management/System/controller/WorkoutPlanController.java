package com.example.Gym.Management.System.controller;

import com.example.Gym.Management.System.dto.WorkoutPlanCreateDto;
import com.example.Gym.Management.System.dto.WorkoutPlanDto;
import com.example.Gym.Management.System.service.WorkoutPlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
public class WorkoutPlanController {
    private final WorkoutPlanService workoutPlanService;
    //dependency injection
    public WorkoutPlanController(WorkoutPlanService workoutPlanService) {
        this.workoutPlanService = workoutPlanService;
    }

    @GetMapping
    public ResponseEntity<List<WorkoutPlanDto>> getAllWorkouts() {
        return ResponseEntity.ok(workoutPlanService.getWorkouts());
    }

    @PostMapping
    public ResponseEntity<WorkoutPlanDto> addWorkoutPlan(@RequestBody WorkoutPlanCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(workoutPlanService.createWorkoutPlan(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkoutPlan(@PathVariable Long id) {
        workoutPlanService.deleteWorkoutPlan(id);
        return ResponseEntity.noContent().build();
    }

}
