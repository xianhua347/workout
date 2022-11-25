package com.example.workout.service;

import com.example.workout.dto.WorkOutDto;
import com.example.workout.entity.Event;
import com.example.workout.entity.WorkOut;
import com.example.workout.exception.BizException;
import com.example.workout.exception.ExceptionType;
import com.example.workout.mapper.WorkOutMapper;
import com.example.workout.repository.WorkOutRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class WorkOutService {

    private final WorkOutRepository workOutRepository;

    private final WorkOutMapper workOutMapper;

    public WorkOutService(WorkOutRepository workOutRepository, WorkOutMapper workOutMapper) {
        this.workOutRepository = workOutRepository;
        this.workOutMapper = workOutMapper;
    }

    public WorkOut save(WorkOutDto workOutDto) {
        final WorkOut workOut = workOutMapper.workOutDtoToWorkOut(workOutDto);
        return workOutRepository.save(workOut);
    }

    public List<WorkOut> save(List<WorkOut> workOuts) {
        return workOutRepository.saveAll(workOuts);
    }

    public List<WorkOut> findAllWorkOut() {
        final List<WorkOut> workOuts = workOutRepository.findAll();
        return workOuts;
    }

    public Optional<WorkOut> findById(String id) {
        final Optional<WorkOut> workOut = workOutRepository.findById(id);
        return workOut;
    }

    public void delete(WorkOut workOut) {
        workOutRepository.delete(workOut);
    }

    public void deleteAll() {
        workOutRepository.deleteAll();
    }

    public Double duration(String title) {
        final Optional<WorkOut> workOut = workOutRepository.findByTitle(title);
        if (workOut.isPresent()) {
            return workOut
                    .get()
                    .getEvents()
                    .stream()
                    .mapToDouble(Event::getDuration)
                    .sum();
        } else {
            throw new BizException(ExceptionType.NOT_FOUND);
        }
    }

    @Transactional
    public Boolean update(String id, WorkOutDto workOutDto) {
        final Optional<WorkOut> optional = workOutRepository.findById(id);
        final WorkOut v = workOutMapper.workOutDtoToWorkOut(workOutDto);
        optional.ifPresentOrElse(workOut -> {
            workOut.setTitle(v.getTitle());
            workOut.setPosition(v.getPosition());
            workOut.setDuration(v.getDuration());
            workOut.setVersion(v.getVersion());
            workOut.setUpdatedTime(v.getUpdatedTime());
            workOut.setEvents(v.getEvents());
        }, () -> {
            throw new BizException(ExceptionType.UPDATE_ERROR);
        });
        return true;
    }
}
