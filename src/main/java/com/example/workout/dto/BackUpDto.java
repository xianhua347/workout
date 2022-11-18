package com.example.workout.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.workout.entity.BackUp} entity
 */
public class BackUpDto extends AbstractEntityDto implements Serializable {
    private List<WorkOutDto> workOuts;

    public BackUpDto(List<WorkOutDto> workOuts) {
        this.workOuts = workOuts;
    }
    public List<WorkOutDto> getWorkOuts() {
        return workOuts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BackUpDto)) return false;
        if (!super.equals(o)) return false;
        BackUpDto backUpDto = (BackUpDto) o;
        return Objects.equals(getWorkOuts(), backUpDto.getWorkOuts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWorkOuts());
    }

}