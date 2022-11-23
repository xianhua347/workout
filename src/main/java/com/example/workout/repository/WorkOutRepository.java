package com.example.workout.repository;

import com.example.workout.entity.WorkOut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkOutRepository extends JpaRepository<WorkOut, String> {
    Optional<WorkOut> findByTitle(String title);
}