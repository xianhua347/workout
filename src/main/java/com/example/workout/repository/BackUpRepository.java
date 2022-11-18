package com.example.workout.repository;

import com.example.workout.entity.BackUp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BackUpRepository extends JpaRepository<BackUp, String> {
}