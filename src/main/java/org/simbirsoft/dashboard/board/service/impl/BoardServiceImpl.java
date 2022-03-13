package org.simbirsoft.dashboard.board.service.impl;

import org.simbirsoft.dashboard.board.entity.Board;
import org.simbirsoft.dashboard.board.entity.dto.BoardResponseDto;
import org.simbirsoft.dashboard.board.mapper.BoardMapper;
import org.simbirsoft.dashboard.board.repository.BoardRepository;
import org.simbirsoft.dashboard.board.service.BoardService;
import org.simbirsoft.dashboard.project.entity.Project;
import org.simbirsoft.dashboard.project.repository.ProjectRepository;
import org.simbirsoft.dashboard.task.entity.Status;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    private final ProjectRepository projectRepository;

    private final BoardMapper boardMapper;

    public BoardServiceImpl(BoardRepository boardRepository,
                            ProjectRepository projectRepository,
                            BoardMapper boardMapper){
        this.projectRepository = projectRepository;
        this.boardRepository = boardRepository;
        this.boardMapper = boardMapper;
    }

    @Override
    public BoardResponseDto create(Long projectId) {
        Optional<Project> project = projectRepository.findById(projectId);

        Board board = boardRepository.save(new Board());

        if (project.isPresent()){
            project.get().setBoard(board);
            projectRepository.save(project.get());
        }
        return boardMapper.fromEntity(board);
    }

    @Override
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    public BoardResponseDto getById(Long id) {
        return boardMapper.fromEntity(boardRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Board not found")));
    }

    @Override
    public Long getCountUnfinishedTask(Long id) {
        Optional<Board> board = boardRepository.findById(id);
        if (board.isPresent()){
            return board.
                    get().
                    getTasks().
                    stream().
                    filter(task -> task.getStatus().equals(Status.IN_PROGRESS)).
                    count();

        } else {
            throw new RuntimeException("Board not present");
        }
    }
}
