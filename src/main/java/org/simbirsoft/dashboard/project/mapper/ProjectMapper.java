package org.simbirsoft.dashboard.project.mapper;

import org.simbirsoft.dashboard.board.mapper.BoardMapper;
import org.simbirsoft.dashboard.project.entity.Project;
import org.simbirsoft.dashboard.project.entity.dto.ProjectRequestDto;
import org.simbirsoft.dashboard.project.entity.dto.ProjectResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    private final BoardMapper boardMapper;

    public ProjectMapper(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public Project fromDto(ProjectRequestDto projectRequestDto) {
        Project project = new Project();

        project.setTitle(projectRequestDto.getTitle());
        project.setDescription(projectRequestDto.getDescription());

        return project;
    }

    public ProjectResponseDto fromEntity(Project project) {

        ProjectResponseDto projectResponseDto = new ProjectResponseDto();

        projectResponseDto.setId(project.getId());

        if (project.getBoard() != null) {
            projectResponseDto.setBoard(boardMapper.fromEntity(project.getBoard()));
        }
        projectResponseDto.setTitle(project.getTitle());
        projectResponseDto.setDescription(project.getDescription());
        projectResponseDto.setStatus(project.getStatus());

        return projectResponseDto;
    }
}
