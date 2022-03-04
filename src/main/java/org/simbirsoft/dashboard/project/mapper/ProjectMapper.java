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
        return null;
    }

    public ProjectResponseDto fromEntity(Project byId) {
        return null;
    }
}
