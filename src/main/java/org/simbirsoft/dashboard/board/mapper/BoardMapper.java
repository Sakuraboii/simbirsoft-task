package org.simbirsoft.dashboard.board.mapper;

import org.simbirsoft.dashboard.board.entity.Board;
import org.simbirsoft.dashboard.board.entity.dto.BoardResponseDto;
import org.simbirsoft.dashboard.task.entity.dto.TaskResponseDto;
import org.simbirsoft.dashboard.task.mapper.TaskMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BoardMapper {

    private final TaskMapper taskMapper;

    public BoardMapper(TaskMapper taskMapper){
        this.taskMapper = taskMapper;
    }

    public BoardResponseDto fromEntity(Board board) {
        BoardResponseDto boardResponseDto = new BoardResponseDto();

        List<TaskResponseDto> taskResponseDtos = taskMapper.fromEntities(board.getTasks());

        boardResponseDto.setTaskResponseDtos(taskResponseDtos);
        boardResponseDto.setId(board.getId());

        return boardResponseDto;
    }
}
