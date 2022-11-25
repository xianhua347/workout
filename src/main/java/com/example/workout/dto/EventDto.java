package com.example.workout.dto;

import com.example.workout.entity.Event;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link Event} entity
 */
public class EventDto extends AbstractEntityDto implements Serializable {
    private  Integer repetitions;
    private  Double duration;
    private  List<ExerciseDto> exercises;

    public EventDto() {
        super();
    }

    public EventDto(Integer repetitions, Double duration, List<ExerciseDto> exercises) {
        this.repetitions = repetitions;
        this.duration = duration;
        this.exercises = exercises;
    }


    public Integer getRepetitions() {
        return repetitions;
    }

    public Double getDuration() {
        return duration;
    }

    public List<ExerciseDto> getExercises() {
        return exercises;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventDto)) return false;
        if (!super.equals(o)) return false;
        EventDto eventDto = (EventDto) o;
        return Objects.equals(getRepetitions(), eventDto.getRepetitions()) && Objects.equals(getDuration(), eventDto.getDuration()) && Objects.equals(getExercises(), eventDto.getExercises());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRepetitions(), getDuration(), getExercises());
    }

    @Override
    public String toString() {
        return "EventDto{" +
                "repetitions=" + repetitions +
                ", duration=" + duration +
                ", exercises=" + exercises +
                '}';
    }
}