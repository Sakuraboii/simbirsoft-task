package org.simbirsoft.dashboard.task.controller;

import org.simbirsoft.dashboard.core.urls.Task;
import org.simbirsoft.dashboard.task.entity.dto.TaskRequestDto;
import org.simbirsoft.dashboard.task.entity.dto.TaskResponseDto;
import org.simbirsoft.dashboard.task.mapper.TaskMapper;
import org.simbirsoft.dashboard.task.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Task.task)
public class TaskController {

    private final TaskService taskService;

    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService,TaskMapper taskMapper){
        this.taskMapper = taskMapper;
        this.taskService = taskService;
    }

    @PostMapping
    public void createTask(@RequestBody TaskRequestDto taskRequestDto, String boardId){
        taskService.save(taskMapper.fromDto(taskRequestDto), boardId);
    }

    @PutMapping
    public void updateTask(@RequestBody TaskRequestDto taskRequestDto, String taskId){
        taskService.update(taskMapper.fromDto(taskRequestDto), taskId);
    }

    @DeleteMapping
    public void deleteTask(String taskId){
        taskService.delete(taskId);
    }

}
