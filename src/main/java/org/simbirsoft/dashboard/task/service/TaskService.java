package org.simbirsoft.dashboard.task.service;

import org.simbirsoft.dashboard.task.entity.Task;

public interface TaskService {
    void save(Task task);

    void delete(String taskId);

    void update(Task fromDto, String taskId);
}
