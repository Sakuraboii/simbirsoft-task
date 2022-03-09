package org.simbirsoft.dashboard.project.service.impl;

import org.simbirsoft.dashboard.project.entity.Project;
import org.simbirsoft.dashboard.project.entity.dto.ProjectRequestDto;
import org.simbirsoft.dashboard.project.entity.dto.ProjectResponseDto;
import org.simbirsoft.dashboard.project.mapper.ProjectMapper;
import org.simbirsoft.dashboard.project.repository.ProjectRepository;
import org.simbirsoft.dashboard.project.service.ProjectService;
import org.simbirsoft.dashboard.task.entity.Status;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository,ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public void create(ProjectRequestDto projectRequestDto) {

        Project project = projectMapper.fromDto(projectRequestDto);

        project.setStatus(Status.IN_PROGRESS);
        projectRepository.save(project);
    }

    @Override
    public ProjectResponseDto getById(Long id) {
        return projectMapper.fromEntity(projectRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Project not found")));
    }

    @Override
    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectResponseDto updateProject(ProjectRequestDto projectRequestDto, Long projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        if (project.isPresent()){
            project.get().setDescription(projectRequestDto.getDescription() == null ?
                    project.get().getDescription() : projectRequestDto.getDescription());
            project.get().setTitle(projectRequestDto.getTitle() == null ?
                    project.get().getTitle() : projectRequestDto.getTitle());

            return projectMapper.fromEntity(projectRepository.save(project.get()));
        } else {
            throw new RuntimeException("Project not found");
        }
    }
}
