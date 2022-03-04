package org.simbirsoft.dashboard.project.service;

import org.simbirsoft.dashboard.project.entity.Project;
import org.simbirsoft.dashboard.project.entity.dto.ProjectRequestDto;

public interface ProjectService {
    void create(Project project);

    Project getById(String id);

    void deleteById(String id);

    void updateProject(ProjectRequestDto projectRequestDto, String projectId);
}
