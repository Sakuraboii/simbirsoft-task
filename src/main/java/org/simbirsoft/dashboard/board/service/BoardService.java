package org.simbirsoft.dashboard.board.service;

import org.simbirsoft.dashboard.board.entity.dto.BoardResponseDto;

public interface BoardService {
    BoardResponseDto create(Long projectId);

    void deleteById(Long id);

    BoardResponseDto getById(Long id);

    Long getCountUnfinishedTask(Long id);
}
