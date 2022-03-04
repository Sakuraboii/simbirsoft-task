package org.simbirsoft.dashboard.task.service;

import org.simbirsoft.dashboard.task.entity.Task;

public interface TaskService {
    void save(Task task ,String boardId);

    void delete(String taskId);

    void update(Task fromDto, String taskId);
}
