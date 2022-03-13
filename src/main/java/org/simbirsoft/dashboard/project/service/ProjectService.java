package org.simbirsoft.dashboard.project.service;

import org.simbirsoft.dashboard.project.entity.dto.ProjectRequestDto;
import org.simbirsoft.dashboard.project.entity.dto.ProjectResponseDto;

public interface ProjectService {
    void create(ProjectRequestDto project);

    ProjectResponseDto getById(Long id);

    void deleteById(Long id);

    ProjectResponseDto updateProject(ProjectRequestDto projectRequestDto, Long projectId);
}
