package org.simbirsoft.dashboard.task.service;

import org.simbirsoft.dashboard.task.entity.dto.TaskRequestDto;
import org.simbirsoft.dashboard.task.entity.dto.TaskResponseDto;

import java.util.List;

public interface TaskService {
    void save(TaskRequestDto task , Long boardId);

    List<TaskResponseDto> delete(Long taskId);

    void update(TaskRequestDto fromDto, Long taskId);
}
