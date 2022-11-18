package com.example.workout.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.workout.entity.Exercise} entity
 */
public class ExerciseDto extends AbstractEntityDto implements Serializable {
    private  String name;
    private  Double duration;

    public ExerciseDto(String name, Double duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public Double getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExerciseDto)) return false;
        if (!super.equals(o)) return false;
        ExerciseDto that = (ExerciseDto) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getDuration(), that.getDuration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getDuration());
    }

    @Override
    public String toString() {
        return "ExerciseDto{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}