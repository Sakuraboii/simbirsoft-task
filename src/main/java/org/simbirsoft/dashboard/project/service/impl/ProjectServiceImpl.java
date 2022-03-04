package org.simbirsoft.dashboard.project.service.impl;

import org.simbirsoft.dashboard.project.entity.Project;
import org.simbirsoft.dashboard.project.entity.dto.ProjectRequestDto;
import org.simbirsoft.dashboard.project.repository.ProjectRepository;
import org.simbirsoft.dashboard.project.service.ProjectService;
import org.simbirsoft.dashboard.task.entity.Status;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void create(Project project) {
        project.setStatus(Status.IN_PROGRESS);
        projectRepository.save(project);
    }

    @Override
    public Project getById(String id) {
        return projectRepository.findById(id).orElseThrow(()->new RuntimeException("Project not found"));
    }

    @Override
    public void deleteById(String id) {
        projectRepository.deleteById(id);
    }

    @Override
    public void updateProject(ProjectRequestDto projectRequestDto, String projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        if (project.isPresent()){
            project.get().setDescription(projectRequestDto.getDescription() == null ?
                    project.get().getDescription() : projectRequestDto.getDescription());
            project.get().setTitle(projectRequestDto.getTitle() == null ?
                    project.get().getTitle() : projectRequestDto.getTitle());

            projectRepository.save(project.get());
        }
    }
}
