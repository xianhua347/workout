package com.example.workout.entity;

import javax.persistence.Column;
import javax.persistence.Entity;



@Entity
public class Exercise extends AbstractEntity{

    @Column(name = "name",columnDefinition = "Varchar(100) not null default 'exercise'")
    private String name = "exercise";

    @Column(name = "duration",columnDefinition = "int default 30")
    private Double duration = 30.0;

    public Exercise() {
    }

    public Exercise(String name, Double duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
