package com.example.workout.mapper;

import com.example.workout.annotations.MappingIgnore;
import com.example.workout.dto.ExerciseDto;
import com.example.workout.entity.Exercise;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ExerciseMapper {

    @MappingIgnore
    Exercise exerciseDtoToExercise(ExerciseDto exerciseDto);

    @MappingIgnore
    ExerciseDto exerciseToExerciseDto(Exercise exercise);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Exercise updateExerciseFromExerciseDto(ExerciseDto exerciseDto, @MappingTarget Exercise exercise);
}
