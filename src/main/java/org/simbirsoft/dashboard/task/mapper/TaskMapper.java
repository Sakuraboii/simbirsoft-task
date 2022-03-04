package org.simbirsoft.dashboard.task.mapper;

import org.simbirsoft.dashboard.task.entity.Task;
import org.simbirsoft.dashboard.task.entity.dto.TaskRequestDto;
import org.simbirsoft.dashboard.task.entity.dto.TaskResponseDto;
import org.simbirsoft.dashboard.user.entity.User;
import org.simbirsoft.dashboard.user.mapper.UserMapper;
import org.simbirsoft.dashboard.user.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskMapper {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public TaskMapper(UserRepository userRepository,UserMapper userMapper){
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public Task fromDto(TaskRequestDto taskRequestDto) {

        Task task = new Task();

        User author = userRepository.findById(taskRequestDto.getAuthorId()).orElseThrow();
        User executor = userRepository.findById(taskRequestDto.getExecutorId()).orElseThrow();

        task.setAuthor(author);
        task.setExecutor(executor);
        task.setReleaseVersion(taskRequestDto.getReleaseVersion());
        task.setCompletionDate(taskRequestDto.getCompletionDate());
        task.setRegistrationDate(taskRequestDto.getRegistrationDate());
        task.setStatus(taskRequestDto.getStatus());

        return task;
    }

    public TaskResponseDto fromEntity(Task task){
        TaskResponseDto taskResponseDto = new TaskResponseDto();

        taskResponseDto.setId(task.getId());
        taskResponseDto.setAuthor(userMapper.fromEntity(task.getAuthor()));
        taskResponseDto.setExecutor(userMapper.fromEntity(task.getExecutor()));
        taskResponseDto.setCompletionDate(task.getCompletionDate());
        taskResponseDto.setRegistrationDate(task.getRegistrationDate());
        taskResponseDto.setStatus(task.getStatus());
        taskResponseDto.setReleaseVersion(task.getReleaseVersion());

        return taskResponseDto;
    }

    public List<TaskResponseDto> fromEntities(List<Task> tasks){
        List<TaskResponseDto> taskList = new ArrayList<>();

        for (Task task : tasks){
            taskList.add(fromEntity(task));
        }

        return taskList;
    }
}
