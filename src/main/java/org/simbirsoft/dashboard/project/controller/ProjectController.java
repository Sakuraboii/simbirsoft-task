package org.simbirsoft.dashboard.project.controller;

import org.simbirsoft.dashboard.core.urls.Project;
import org.simbirsoft.dashboard.project.entity.dto.ProjectRequestDto;
import org.simbirsoft.dashboard.project.entity.dto.ProjectResponseDto;
import org.simbirsoft.dashboard.project.mapper.ProjectMapper;
import org.simbirsoft.dashboard.project.service.ProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Project.project)
public class ProjectController {

    private final ProjectService projectService;

    private final ProjectMapper projectMapper;

    public ProjectController(ProjectService projectService, ProjectMapper projectMapper) {
        this.projectService = projectService;
        this.projectMapper = projectMapper;
    }

    @PostMapping
    public void create(@RequestBody ProjectRequestDto projectRequestDto){
        projectService.create(projectMapper.fromDto(projectRequestDto));
    }

    @GetMapping
    public ProjectResponseDto getById(String id){
        return projectMapper.fromEntity(projectService.getById(id));
    }

    @DeleteMapping
    public void deleteById(String id){
        projectService.deleteById(id);
    }

    @PutMapping
    public void updateProject(@RequestBody ProjectRequestDto projectRequestDto, String projectId){
        projectService.updateProject(projectRequestDto,projectId);
    }
}
