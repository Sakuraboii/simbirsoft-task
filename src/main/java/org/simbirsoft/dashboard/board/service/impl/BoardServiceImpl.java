package org.simbirsoft.dashboard.board.service.impl;

import org.simbirsoft.dashboard.board.entity.Board;
import org.simbirsoft.dashboard.board.repository.BoardRepository;
import org.simbirsoft.dashboard.board.service.BoardService;
import org.simbirsoft.dashboard.task.entity.Status;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Override
    public Board create() {
        return boardRepository.save(new Board());
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
