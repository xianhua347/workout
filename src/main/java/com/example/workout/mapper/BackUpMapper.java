package com.example.workout.mapper;

import com.example.workout.annotations.MappingIgnore;
import com.example.workout.dto.BackUpDto;
import com.example.workout.entity.BackUp;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component

public interface BackUpMapper {

    @MappingIgnore
    BackUp backUpDtoToBackUp(BackUpDto backUpDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BackUp updateBackUpFromBackUpDto(BackUpDto backUpDto, @MappingTarget BackUp backUp);
}
