package com.example.workout.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class WorkOutDto extends AbstractEntityDto implements Serializable {
    private String title;
    private Integer version;
    private Integer position;
    private Double duration;
    private List<EventDto> events;

    public WorkOutDto(){
        super();
    }
    public WorkOutDto(String title, Integer version, Integer position, Double duration, List<EventDto> events) {
        this.title = title;
        this.version = version;
        this.position = position;
        this.duration = duration;
        this.events = events;
    }

    public String getTitle() {
        return title;
    }

    public Integer getVersion() {
        return version;
    }

    public Integer getPosition() {
        return position;
    }

    public Double getDuration() {
        return duration;
    }

    public List<EventDto> getEvents() {
        return events;
    }

    @Override
    public String toString() {
        return "WorkOutDto{" +
                "title='" + title + '\'' +
                ", version=" + version +
                ", position=" + position +
                ", duration=" + duration +
                ", events=" + events +
                '}';
    }
}