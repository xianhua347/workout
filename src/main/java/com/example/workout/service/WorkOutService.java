package com.example.workout.service;

import com.example.workout.entity.Event;
import com.example.workout.entity.WorkOut;
import com.example.workout.exception.BizException;
import com.example.workout.exception.ExceptionType;
import com.example.workout.repository.WorkOutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkOutService {

    private final WorkOutRepository workOutRepository;

    public WorkOutService(WorkOutRepository workOutRepository) {
        this.workOutRepository = workOutRepository;
    }

    public WorkOut save(WorkOut workOut){
        if (workOutRepository.findById(workOut.getId()).isPresent()) {
            throw new BizException(ExceptionType.DUPLICATE);
        }
        return workOutRepository.save(workOut);
    }

    public List<WorkOut> save(List<WorkOut> workOuts){
      return workOutRepository.saveAll(workOuts);
    }

    public List<WorkOut> findAllWorkOut(){
        final List<WorkOut> workOuts = workOutRepository.findAll();
        return workOuts;
    }

    public Optional<WorkOut> findById(String id){
        final Optional<WorkOut> workOut = workOutRepository.findById(id);
        return workOut;
    }

    public void delete(WorkOut workOut){
        workOutRepository.delete(workOut);
    }

    public void deleteAll(){
        workOutRepository.deleteAll();
    }

    public Double duration(String title){
        final Optional<WorkOut> workOut = workOutRepository.findByTitle(title);
        if (workOut.isPresent()){
           return workOut
                   .get()
                   .getEvents()
                   .stream()
                   .mapToDouble(Event::getDuration)
                   .sum();
        }else {
            throw new BizException(ExceptionType.NOT_FOUND);
        }
    }
}
