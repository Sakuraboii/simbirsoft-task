package org.simbirsoft.dashboard.task.repository;

import org.simbirsoft.dashboard.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
