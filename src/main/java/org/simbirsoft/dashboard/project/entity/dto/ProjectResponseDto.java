package org.simbirsoft.dashboard.project.entity.dto;

import org.simbirsoft.dashboard.board.entity.dto.BoardResponseDto;
import org.simbirsoft.dashboard.task.entity.Status;

public class ProjectResponseDto {

    private String id;

    private BoardResponseDto board;

    private String title;

    private String description;

    private Status status;

    public String getId() {
        return id;
    }

    public BoardResponseDto getBoard() {
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

    public void setId(String id) {
        this.id = id;
    }

    public void setBoard(BoardResponseDto board) {
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
}
