package com.example.workout.annotations;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
@Mappings(value = {
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "createdTime", ignore = true),
        @Mapping(target = "updatedTime", ignore = true)
})
public @interface MappingIgnore {
}
