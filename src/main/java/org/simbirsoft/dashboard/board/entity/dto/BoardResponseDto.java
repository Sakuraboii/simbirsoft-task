package org.simbirsoft.dashboard.board.entity.dto;

import org.simbirsoft.dashboard.task.entity.dto.TaskResponseDto;

import java.util.List;

public class BoardResponseDto {
    private String id;

    private List<TaskResponseDto> taskResponseDtos;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<TaskResponseDto> getTaskResponseDtos() {
        return taskResponseDtos;
    }

    public void setTaskResponseDtos(List<TaskResponseDto> taskResponseDtos) {
        this.taskResponseDtos = taskResponseDtos;
    }
}
