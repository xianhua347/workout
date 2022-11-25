package com.example.workout.mapper;


import com.example.workout.annotations.MappingIgnore;
import com.example.workout.dto.WorkOutDto;
import com.example.workout.entity.WorkOut;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface WorkOutMapper {

    @MappingIgnore
    WorkOut workOutDtoToWorkOut(WorkOutDto workOutDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    WorkOut updateWorkOutFromWorkOutDto(WorkOutDto workOutDto, @MappingTarget WorkOut workOut);
}
