package org.simbirsoft.dashboard.board.service;

import org.simbirsoft.dashboard.board.entity.Board;

public interface BoardService {
    Board create(String projectId);

    void deleteById(String id);

    Board getById(String id);

    Long getCountUnfinishedTask(String id);
}
