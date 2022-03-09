package org.simbirsoft.dashboard.task.controller;

import org.simbirsoft.dashboard.core.urls.Task;
import org.simbirsoft.dashboard.task.entity.dto.TaskRequestDto;
import org.simbirsoft.dashboard.task.entity.dto.TaskResponseDto;
import org.simbirsoft.dashboard.task.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Task.TASK)
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public void createTask(@RequestBody TaskRequestDto taskRequestDto, Long boardId){
        taskService.save(taskRequestDto, boardId);
    }

    @PutMapping
    public void updateTask(@RequestBody TaskRequestDto taskRequestDto, Long taskId){
        taskService.update(taskRequestDto, taskId);
    }

    @DeleteMapping
    public ResponseEntity<List<TaskResponseDto>> deleteTask(Long taskId){
        return new ResponseEntity<>(taskService.delete(taskId), HttpStatus.OK);
    }

}
