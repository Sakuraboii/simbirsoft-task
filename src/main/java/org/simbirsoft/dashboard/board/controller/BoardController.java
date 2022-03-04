package org.simbirsoft.dashboard.board.controller;

import org.simbirsoft.dashboard.board.entity.dto.BoardResponseDto;
import org.simbirsoft.dashboard.board.mapper.BoardMapper;
import org.simbirsoft.dashboard.board.service.BoardService;
import org.simbirsoft.dashboard.core.urls.Board;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Board.board)
public class BoardController {

    private final BoardService boardService;

    private final BoardMapper boardMapper;

    public BoardController(BoardService boardService, BoardMapper boardMapper) {
        this.boardService = boardService;
        this.boardMapper = boardMapper;
    }

    @PostMapping
    public BoardResponseDto create(){
        return boardMapper.fromEntity(boardService.create());
    }

    @GetMapping
    public BoardResponseDto getById(String id){
        return boardMapper.fromEntity(boardService.getById(id));
    }

    @DeleteMapping
    public void deleteById(String id){
        boardService.deleteById(id);
    }

    @GetMapping("/count")
    public Long getCountUnfinishedTask(String id){
        return boardService.getCountUnfinishedTask(id);
    }
}
