package com.example.Gym.Management.System.controller;


import com.example.Gym.Management.System.dto.TraineeCreateDto;
import com.example.Gym.Management.System.dto.TraineeDto;
import com.example.Gym.Management.System.service.TraineeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/trainees")
public class TraineeController {
    private final TraineeService traineeService;
    //dependency...
    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping
    public ResponseEntity<List<TraineeDto>> getAllTrainees() {
        return ResponseEntity.ok(traineeService.getTrainers());
    }

    @PostMapping
    public ResponseEntity<TraineeDto> createTrainee(@RequestBody TraineeCreateDto traineeDto) {
        return ResponseEntity.ok(traineeService.createTrainer(traineeDto));
    }

    @PutMapping("/{traineeId}/assign-plan/{planId}")
    public ResponseEntity<TraineeDto> updateTraineePlan(@PathVariable Long traineeId, @PathVariable Long planId) {
        for(TraineeDto t : traineeService.getTrainers()) {
            if(t.getId().equals(traineeId)) {
                t.setActivePlanId(planId);
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{traineeId}/remove-plan")
    public ResponseEntity<Void> removeTraineePlan(@PathVariable Long traineeId) {
        for(TraineeDto t : traineeService.getTrainers()) {
            if(t.getId().equals(traineeId)) {
                t.setActivePlanId(null);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
