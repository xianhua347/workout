package com.example.workout.service;

import com.example.workout.dto.ExerciseDto;
import com.example.workout.entity.Exercise;
import com.example.workout.exception.BizException;
import com.example.workout.exception.ExceptionType;
import com.example.workout.mapper.ExerciseMapper;
import com.example.workout.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    private final ExerciseMapper exerciseMapper;

    public ExerciseService(ExerciseRepository exerciseRepository, ExerciseMapper exerciseMapper) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseMapper = exerciseMapper;
    }

    public Exercise save(ExerciseDto exerciseDto) throws ClassNotFoundException{
        if (exerciseDto != null) {
           return exerciseRepository.save(exerciseMapper.exerciseDtoToExercise(exerciseDto));
        }else {
            throw new ClassNotFoundException("查不到数据");
        }
    }

    public List<Exercise> save(List<Exercise> exerciseDtos) throws ClassNotFoundException{
        if (exerciseDtos != null) {
            return exerciseRepository.saveAll(exerciseDtos);
        }else {
            throw new NullPointerException("查不到数据");
        }
    }

    public boolean update(String id, ExerciseDto exerciseDto){
        final Optional<Exercise> optional = exerciseRepository.findById(id);
        final Exercise v = exerciseMapper.exerciseDtoToExercise(exerciseDto);
        optional.ifPresentOrElse(ex -> {
            ex.setUpdatedTime(v.getUpdatedTime());
            ex.setDuration(v.getDuration());
            ex.setUpdatedTime(v.getUpdatedTime());
            ex.setName(v.getName());
        }, () -> {
            throw new BizException(ExceptionType.UPDATE_ERROR);
        });
        return true;
    }

    public void delete(String id) {
        if (!id.isEmpty()){
            exerciseRepository.deleteById(id);
        }else {
            throw new BizException(ExceptionType.PARAMETERS_CANNOT_BE_EMPTY);
        }
    }

    public Optional<Exercise> find(String id){
        if (!id.isEmpty()){
            if (exerciseRepository.findById(id).isPresent()){
                return exerciseRepository.findById(id);
            }else {
                throw new BizException(ExceptionType.NOT_FOUND);
            }
        }else{
            throw new BizException(ExceptionType.PARAMETERS_CANNOT_BE_EMPTY);
        }
    }
}
