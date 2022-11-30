package com.example.workout.service;

import com.example.workout.entity.BackUp;
import com.example.workout.repository.BackUpRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BackUpService {

    private final BackUpRepository backUpRepository;

    public BackUpService(BackUpRepository backUpRepository) {
        this.backUpRepository = backUpRepository;
    }

    public Optional<BackUp> backUpdate(String id){
        return backUpRepository.findById(id);
    }
}
