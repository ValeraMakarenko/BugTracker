package com.bug.tracker.mapper;

import com.bug.tracker.dto.TypeProjectDto;
import com.bug.tracker.model.TypeProject;

import java.util.List;

public interface TypeProjectMapper {

    TypeProjectDto typeProjectToTypeProjectDto(TypeProject typeProject);

    TypeProject typeProjectDtoToTypeProject(TypeProjectDto typeProjectDto);

    List<TypeProject> typeProjectDtosToTypeProjects (List<TypeProjectDto> typeProjectDtoList);

    List<TypeProjectDto> typeProjectsToTypeProjectDtos(List<TypeProject> typeProjectList);
}
