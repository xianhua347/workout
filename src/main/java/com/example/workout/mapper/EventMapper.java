package com.example.workout.mapper;

import com.example.workout.annotations.MappingIgnore;
import com.example.workout.entity.Event;
import com.example.workout.dto.EventDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface EventMapper {

    @MappingIgnore
    Event eventDtoToEvent(EventDto eventDto);


    @MappingIgnore
    List<Event> eventListDtoToEvent(List<EventDto> eventDtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Event updateEventFromEventDto(EventDto eventDto, @MappingTarget Event event);
}
