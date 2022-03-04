package org.simbirsoft.dashboard.board.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;
import org.simbirsoft.dashboard.task.entity.Task;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SIMBIRSOFT_BOARD")
public class Board {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @OneToMany
    private List<Task> tasks;

    public Board(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Board(){}

    public String getId() {
        return id;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
