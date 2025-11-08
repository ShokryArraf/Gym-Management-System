package com.example.Gym.Management.System.service;

import com.example.Gym.Management.System.dto.TraineeCreateDto;
import com.example.Gym.Management.System.dto.TraineeDto;
import com.example.Gym.Management.System.exception.DuplicateResourceException;
import com.example.Gym.Management.System.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TraineeService {
    private final List<TraineeDto> trainers = new ArrayList<>();
    private Long nextId = 1L;


    // CRUD
    public TraineeDto createTrainer(TraineeCreateDto dto) {
        TraineeDto trainer = new TraineeDto();
        String email = dto.getEmail();
        for(TraineeDto t : trainers){
            if(t.getEmail().equals(email)){
                throw new DuplicateResourceException("Email already exists");
            }
        }
        trainer.setId(nextId++);
        trainer.setName(dto.getName());
        trainer.setJoinDate(dto.getJoinDate());
        trainer.setEmail(dto.getEmail());
        trainer.setActivePlanId(dto.getActivePlanId());
        trainers.add(trainer);
        return trainer;
    }

    public TraineeDto updateTrainer(TraineeDto dto) {
        for(TraineeDto t : trainers){
            if(t.getId().equals(dto.getId())){
                t.setName(dto.getName());
                t.setJoinDate(dto.getJoinDate());
                t.setEmail(dto.getEmail());
                t.setActivePlanId(dto.getActivePlanId());
                return t;
            }
        }
        return null;

    }
    public void deleteTrainer(TraineeDto dto) {
        for(TraineeDto t : trainers){
            if(t.getId().equals(dto.getId())){
                trainers.remove(t);
                break;
            }
        }
        throw new ResourceNotFoundException("Trainer not found");
    }

    public List<TraineeDto> getTrainers() {
        return new ArrayList<>(this.trainers);
    }

    public TraineeDto updateTraineePlan(Long Id,Long planId) {
        for(TraineeDto t : this.trainers) {
            if(t.getId().equals(Id)) {
                t.setActivePlanId(planId);
                return t;
            }
        }
        throw new ResourceNotFoundException("Trainee not found to update");
    }

    public TraineeDto removeTraineePlan(Long id) {
        for(TraineeDto t : this.trainers) {
            if(t.getId().equals(id)) {
                t.setActivePlanId(null);
                return t;
            }
        }
        throw new ResourceNotFoundException("Trainee not found to remove the plan");
    }
    public List<TraineeDto> getJoinedAfterTrainees(String date) {
        List<TraineeDto> result = new ArrayList<>();
        for(TraineeDto t : this.trainers) {
            if(t.getJoinDate().isAfter(LocalDate.parse(date))) {
                result.add(t);
            }
        }
        return result;

    }
    public Map<Integer, List<TraineeDto>> getGroupedByYear() {
        return this.trainers.stream()
                .collect(Collectors.groupingBy(t -> t.getJoinDate().getYear()));
    }
}
