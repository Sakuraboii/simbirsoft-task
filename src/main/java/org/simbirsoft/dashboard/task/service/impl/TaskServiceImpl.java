package org.simbirsoft.dashboard.task.service.impl;

import org.simbirsoft.dashboard.task.entity.Task;
import org.simbirsoft.dashboard.task.repository.TaskRepository;
import org.simbirsoft.dashboard.task.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void delete(String taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public void update(Task task, String taskId) {
        Task taskSave = taskRepository.findById(taskId).orElseThrow();

        taskSave.setAuthor(task.getAuthor() == null ? taskSave.getAuthor() : task.getAuthor());
        taskSave.setExecutor(task.getExecutor() == null ? taskSave.getExecutor() : task.getExecutor());
        taskSave.setCompletionDate(task.getCompletionDate() == null ? taskSave.getCompletionDate() : task.getCompletionDate());
        taskSave.setStatus(task.getStatus() == null ? taskSave.getStatus() : task.getStatus());
        taskSave.setRegistrationDate(task.getRegistrationDate() == null ? taskSave.getRegistrationDate() : task.getRegistrationDate());
        taskSave.setReleaseVersion(task.getReleaseVersion() == null ? taskSave.getReleaseVersion() : task.getReleaseVersion());

        taskRepository.save(taskSave);
    }
}
