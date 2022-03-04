package org.simbirsoft.dashboard.board.service.impl;

import org.simbirsoft.dashboard.board.entity.Board;
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

    public BoardServiceImpl(BoardRepository boardRepository,ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
        this.boardRepository = boardRepository;
    }

    @Override
    public Board create(String projectId) {
        Optional<Project> project = projectRepository.findById(projectId);

        Board board = boardRepository.save(new Board());

        if (project.isPresent()){
            project.get().setBoard(board);
            projectRepository.save(project.get());
        }
        return board;
    }

    @Override
    public void deleteById(String id) {
        boardRepository.deleteById(id);
    }

    @Override
    public Board getById(String id) {
        return boardRepository.findById(id).orElseThrow(() -> new RuntimeException("Board not found"));
    }

    @Override
    public Long getCountUnfinishedTask(String id) {
        Optional<Board> board = boardRepository.findById(id);
        if (board.isPresent()){
            return board.
                    get().
                    getTasks().
                    stream().
                    filter(task -> task.getStatus().equals(Status.IN_PROGRESS)).
                    count();

        } else {
            return null;
        }
    }
}
