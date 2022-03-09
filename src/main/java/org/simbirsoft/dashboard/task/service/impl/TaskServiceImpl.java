package org.simbirsoft.dashboard.task.service.impl;

import org.simbirsoft.dashboard.board.entity.Board;
import org.simbirsoft.dashboard.board.repository.BoardRepository;
import org.simbirsoft.dashboard.task.entity.Task;
import org.simbirsoft.dashboard.task.entity.dto.TaskRequestDto;
import org.simbirsoft.dashboard.task.entity.dto.TaskResponseDto;
import org.simbirsoft.dashboard.task.mapper.TaskMapper;
import org.simbirsoft.dashboard.task.repository.TaskRepository;
import org.simbirsoft.dashboard.task.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final BoardRepository boardRepository;

    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository,
                           BoardRepository boardRepository,
                           TaskMapper taskMapper) {
        this.boardRepository = boardRepository;
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public void save(TaskRequestDto taskRequestDto, Long boardId) {
        Optional<Board> board = boardRepository.findById(boardId);

        Task task = taskMapper.fromDto(taskRequestDto);

        Task taskSave = taskRepository.save(task);
        if (board.isPresent()) {
            board.get().getTasks().add(taskSave);
            boardRepository.save(board.get());
        }

    }

    @Override
    public List<TaskResponseDto> delete(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));

        taskRepository.deleteById(taskId);

        Board board = boardRepository.findByTasksContains(task);

        return taskMapper.fromEntities(board.getTasks());
    }

    @Override
    public void update(TaskRequestDto taskRequestDto, Long taskId) {
        Task taskSave = taskRepository.findById(taskId).orElseThrow();

        Task task = taskMapper.fromDto(taskRequestDto);

        taskSave.setAuthor(task.getAuthor() == null ? taskSave.getAuthor() : task.getAuthor());
        taskSave.setExecutor(task.getExecutor() == null ? taskSave.getExecutor() : task.getExecutor());
        taskSave.setCompletionDate(task.getCompletionDate() == null ? taskSave.getCompletionDate() : task.getCompletionDate());
        taskSave.setStatus(task.getStatus() == null ? taskSave.getStatus() : task.getStatus());
        taskSave.setRegistrationDate(task.getRegistrationDate() == null ? taskSave.getRegistrationDate() : task.getRegistrationDate());
        taskSave.setReleaseVersion(task.getReleaseVersion() == null ? taskSave.getReleaseVersion() : task.getReleaseVersion());

        taskRepository.save(taskSave);
    }
}
