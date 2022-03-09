package org.simbirsoft.dashboard.project.repository;

import org.simbirsoft.dashboard.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
