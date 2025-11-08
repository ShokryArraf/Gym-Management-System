package com.example.Gym.Management.System.controller;


import com.example.Gym.Management.System.dto.TraineeCreateDto;
import com.example.Gym.Management.System.dto.TraineeDto;
import com.example.Gym.Management.System.service.TraineeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        return ResponseEntity.status(HttpStatus.CREATED).body(traineeService.createTrainer(traineeDto));
    }

    @PutMapping("/{traineeId}/assign-plan/{planId}")
    public ResponseEntity<TraineeDto> updateTraineePlan(@PathVariable Long traineeId, @PathVariable Long planId) {
        return ResponseEntity.ok(traineeService.updateTraineePlan(traineeId,planId));
    }

    @PutMapping("/{traineeId}/remove-plan")
    public ResponseEntity<TraineeDto> removeTraineePlan(@PathVariable Long traineeId) {
        TraineeDto updated = traineeService.removeTraineePlan(traineeId);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/joined-after/{date}")
    public ResponseEntity<List<TraineeDto>> getJoinedAfterTrainees(@PathVariable String date) {
        return ResponseEntity.ok(traineeService.getJoinedAfterTrainees(date));
    }

    @GetMapping("/grouped-by-year")
    public ResponseEntity<Map<Integer, List<TraineeDto>>> getGroupedByYear() {
        return ResponseEntity.ok(traineeService.getGroupedByYear());
    }
}
