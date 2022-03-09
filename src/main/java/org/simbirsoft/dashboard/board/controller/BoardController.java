package org.simbirsoft.dashboard.board.controller;

import org.simbirsoft.dashboard.board.entity.dto.BoardResponseDto;
import org.simbirsoft.dashboard.board.service.BoardService;
import org.simbirsoft.dashboard.core.urls.Board;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Board.BOARD)
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<BoardResponseDto> create(Long projectId){
        return new ResponseEntity<>(boardService.create(projectId),HttpStatus.OK) ;
    }

    @GetMapping
    public ResponseEntity<BoardResponseDto> getById(Long id){
        return new ResponseEntity<>(boardService.getById(id),HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteById(Long id){
        boardService.deleteById(id);
    }

    @GetMapping(Board.COUNT.COUNT)
    public Long getCountUnfinishedTask(Long id){
        return boardService.getCountUnfinishedTask(id);
    }
}
