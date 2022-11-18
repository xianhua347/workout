package com.example.workout.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Event extends AbstractEntity{


    @Column(name = "repetitions",columnDefinition = "int default 1")
    private Integer repetitions = 1;

    @Column(name = "duration")
    private Double duration;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "exercise_id")
    private List<Exercise> exercises;

    public Event() {
    }

    public Event(Integer repetitions, Double duration, List<Exercise> exercises) {
        this.repetitions = repetitions;
        this.duration = duration;
        this.exercises = exercises;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "Event{" +
                "repetitions=" + repetitions +
                ", duration=" + duration +
                ", exercises=" + exercises +
                '}';
    }
}
