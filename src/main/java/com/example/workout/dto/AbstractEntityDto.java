package com.example.workout.dto;

import com.example.workout.entity.AbstractEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link AbstractEntity} entity
 */
public abstract class AbstractEntityDto implements Serializable {
    private String id;
    private Date createdTime;
    private Date updatedTime;

    public AbstractEntityDto() {
    }

    public AbstractEntityDto(String id, Date createdTime, Date updatedTime) {
        this.id = id;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }


    public String getId() {
        return id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntityDto entity = (AbstractEntityDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.createdTime, entity.createdTime) &&
                Objects.equals(this.updatedTime, entity.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdTime, updatedTime);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "createdTime = " + createdTime + ", " +
                "updatedTime = " + updatedTime + ")";
    }
}