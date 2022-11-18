package com.example.workout.entity;



import javax.persistence.*;
import java.util.List;

@Entity
public class WorkOut extends AbstractEntity{

    @Column(length = 64)
    private String title;

    @Column(name = "version",columnDefinition = "int default 1")
    private Integer version;

    @Column(name = "position",columnDefinition = "int default -1")
    private Integer position;

    @Column(name = "duration")
    private Double duration;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "event_id")
    private List<Event> events;

    public WorkOut() {
    }

    public WorkOut(String title, Integer version, Integer position, Double duration, List<Event> events) {
        this.title = title;
        this.version = version;
        this.position = position;
        this.duration = duration;
        this.events = events;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "WorkOut{" +
                "title='" + title + '\'' +
                ", version=" + version +
                ", position=" + position +
                ", duration=" + duration +
                ", events=" + events +
                '}';
    }
}
