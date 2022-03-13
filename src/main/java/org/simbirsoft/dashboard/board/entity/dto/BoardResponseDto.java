package org.simbirsoft.dashboard.board.entity.dto;

import org.simbirsoft.dashboard.task.entity.dto.TaskResponseDto;

import java.util.List;

public class BoardResponseDto {
    private Long id;

    private List<TaskResponseDto> taskResponseDtos;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<TaskResponseDto> getTaskResponseDtos() {
        return taskResponseDtos;
    }

    public void setTaskResponseDtos(List<TaskResponseDto> taskResponseDtos) {
        this.taskResponseDtos = taskResponseDtos;
    }
}
