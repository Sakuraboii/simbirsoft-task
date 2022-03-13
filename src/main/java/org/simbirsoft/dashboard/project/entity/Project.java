package org.simbirsoft.dashboard.project.entity;

import org.simbirsoft.dashboard.board.entity.Board;
import org.simbirsoft.dashboard.task.entity.Status;

import javax.persistence.*;

@Entity
@Table(name = "SIMBIRSOFT_PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    private Board board;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Long getId() {
        return id;
    }

    public Board getBoard() {
        return board;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Project(Board board, String title, String description, Status status) {
        this.board = board;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Project(){}
}
