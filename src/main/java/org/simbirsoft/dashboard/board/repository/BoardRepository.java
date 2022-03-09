package org.simbirsoft.dashboard.board.repository;

import org.simbirsoft.dashboard.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,String> {
}
