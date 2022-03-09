package org.simbirsoft.dashboard.project.controller;

import org.simbirsoft.dashboard.core.urls.Project;
import org.simbirsoft.dashboard.project.entity.dto.ProjectRequestDto;
import org.simbirsoft.dashboard.project.entity.dto.ProjectResponseDto;
import org.simbirsoft.dashboard.project.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Project.PROJECT)
public class ProjectController {

    private final ProjectService projectService;


    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public void create(@RequestBody ProjectRequestDto projectRequestDto) {
        projectService.create(projectRequestDto);
    }

    @GetMapping
    public ResponseEntity<ProjectResponseDto> getById(Long id) {
        return new ResponseEntity<>(projectService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteById(Long id) {
        projectService.deleteById(id);
    }

    @PutMapping
    public ResponseEntity<ProjectResponseDto> updateProject(@RequestBody ProjectRequestDto projectRequestDto, Long projectId) {
        return new ResponseEntity<>(projectService.updateProject(projectRequestDto, projectId), HttpStatus.OK);
    }
}
