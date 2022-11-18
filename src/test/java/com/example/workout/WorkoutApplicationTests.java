package com.example.workout;

import com.example.workout.dto.ExerciseDto;
import com.example.workout.entity.Exercise;
import com.example.workout.mapper.ExerciseMapper;

import com.example.workout.repository.ExerciseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;





@SpringBootTest
class WorkoutApplicationTests {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private ExerciseMapper exerciseMapper;

    @Test
    void contextLoads() {
        final ExerciseDto exerciseDto = new ExerciseDto( "jumping", 10.0);
        final Exercise exercise = exerciseMapper.exerciseDtoToExercise(exerciseDto);
        exerciseRepository.save(exercise);


    }
}

