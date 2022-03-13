package org.simbirsoft.dashboard.board.repository;

import org.simbirsoft.dashboard.board.entity.Board;
import org.simbirsoft.dashboard.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
    Board findByTasksContains(Task task);
}
