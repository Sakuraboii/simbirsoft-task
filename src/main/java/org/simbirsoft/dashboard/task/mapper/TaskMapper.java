package org.simbirsoft.dashboard.task.mapper;

import org.simbirsoft.dashboard.task.entity.Task;
import org.simbirsoft.dashboard.task.entity.dto.TaskRequestDto;
import org.simbirsoft.dashboard.user.entity.User;
import org.simbirsoft.dashboard.user.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    private final UserRepository userRepository;

    public TaskMapper(UserRepository userRepository){
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
}
