package com.example.workout.repository;

import com.example.workout.entity.WorkOut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkOutRepository extends JpaRepository<WorkOut, String> {
}