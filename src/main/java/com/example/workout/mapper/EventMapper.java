package com.example.workout.mapper;

import com.example.workout.annotations.MappingIgnore;
import com.example.workout.entity.Event;
import com.example.workout.dto.EventDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface EventMapper {

    @MappingIgnore
    Event eventDtoToEvent(EventDto eventDto);

    @MappingIgnore
    EventDto eventToEventDto(Event event);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Event updateEventFromEventDto(EventDto eventDto, @MappingTarget Event event);
}
