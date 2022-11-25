package com.example.workout.service;

import com.example.workout.dto.EventDto;
import com.example.workout.entity.Event;
import com.example.workout.exception.BizException;
import com.example.workout.exception.ExceptionType;
import com.example.workout.mapper.EventMapper;
import com.example.workout.repository.EventRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    private final EventMapper eventMapper;

    public EventService(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    public Event save(EventDto eventDto){
        final Event event = eventMapper.eventDtoToEvent(eventDto);
        return eventRepository.save(event);
    }

    public Event findById(String id){
        try{
            return eventRepository.findById(id).get();
        }catch (RuntimeException exception){
            throw new BizException(ExceptionType.NOT_FOUND);
        }
    }

    public List<Event> findAll(){
        try{
            return eventRepository.findAll();
        }catch (RuntimeException exception){
            throw new BizException(ExceptionType.NOT_FOUND);
        }
    }

    public List<Event> save(List<EventDto> events){
        final List<Event> eventList = eventMapper.eventListDtoToEvent(events);
        return eventRepository.saveAll(eventList);
    }

    public Boolean deleteById(String id){
        try {
            eventRepository.deleteById(id);
            return true;
        }catch (BizException exception){
            throw new BizException(ExceptionType.INNER_ERROR);
        }
    }

    @Transactional
    public Boolean update(String id,EventDto eventDto){
        final Optional<Event> optionalEvent = eventRepository.findById(id);
        final Event v = eventMapper.eventDtoToEvent(eventDto);
        optionalEvent.ifPresentOrElse(event -> {
           event.setDuration(v.getDuration());
           event.setUpdatedTime(v.getUpdatedTime());
           event.setExercises(v.getExercises());
           event.setUpdatedTime(v.getUpdatedTime());
           event.setRepetitions(v.getRepetitions());
        }, () -> {
            throw new BizException(ExceptionType.UPDATE_ERROR);
        });
        return true;
    }

}
