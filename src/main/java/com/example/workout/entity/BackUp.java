package com.example.workout.entity;

import javax.persistence.*;
import java.util.List;


@Entity
public class BackUp extends AbstractEntity{

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "backup_id")
    private List<WorkOut> workOuts;

    public BackUp() {
    }

    public BackUp(List<WorkOut> workOuts) {
        this.workOuts = workOuts;
    }

    public List<WorkOut> getWorkOuts() {
        return workOuts;
    }

    public void setWorkOuts(List<WorkOut> workOuts) {
        this.workOuts = workOuts;
    }

    @Override
    public String toString() {
        return "BackUp{" +
                "workOuts=" + workOuts +
                '}';
    }
}
