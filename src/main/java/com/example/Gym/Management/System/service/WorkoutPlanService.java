package com.example.Gym.Management.System.service;

import com.example.Gym.Management.System.dto.WorkoutPlanCreateDto;
import com.example.Gym.Management.System.dto.WorkoutPlanDto;
import com.example.Gym.Management.System.exception.DuplicateResourceException;
import com.example.Gym.Management.System.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkoutPlanService {
    private final List<WorkoutPlanDto> workouts = new ArrayList<>();
    private Long nextId = 1L;

    // CRUD

    public List<WorkoutPlanDto> getWorkouts() {
        return new ArrayList<>(workouts);
    }

    public WorkoutPlanDto createWorkoutPlan(WorkoutPlanCreateDto dto){
        for (WorkoutPlanDto w : workouts){
            if(w.getName().equalsIgnoreCase(dto.getName())){
                throw new DuplicateResourceException("Workout Plan already exists");
            }
        }
        WorkoutPlanDto workout = new WorkoutPlanDto();
        workout.setName(dto.getName());
        workout.setDescription(dto.getDescription());
        workout.setId(nextId++);
        workout.setDifficulty(dto.getDifficulty());
        workouts.add(workout);
        return workout;
    }

    public void deleteWorkoutPlan(Long id){
        for (WorkoutPlanDto w : workouts){
            if(w.getId().equals(id)){
                workouts.remove(w);
                return;
            }
        }
        throw new DuplicateResourceException("Workout Plan does not exist");
    }
    public WorkoutPlanDto updateWorkoutPlan(Long id, WorkoutPlanCreateDto dto){
        for (WorkoutPlanDto w : workouts){
            if(w.getId().equals(id)){
                w.setDifficulty(dto.getDifficulty());
                w.setName(dto.getName());
                w.setDescription(dto.getDescription());
                return w;
            }
        }
        throw new DuplicateResourceException("Workout Plan does not exist");
    }

    public WorkoutPlanDto getWorkoutPlan(Long id) {
        for (WorkoutPlanDto workoutPlanDto : workouts) {
            if (workoutPlanDto.getId().equals(id)) {
                return workoutPlanDto;
            }
        }
        throw new ResourceNotFoundException("WorkoutPlan with id " + id + " not found");
    }
}
