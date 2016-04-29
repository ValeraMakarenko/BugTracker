package com.bug.tracker.mapper.Impl;

import com.bug.tracker.dto.TypeProjectDto;
import com.bug.tracker.mapper.TypeProjectMapper;
import com.bug.tracker.model.TypeProject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TypeProjectMapperImpl implements TypeProjectMapper {

    @Override
    public TypeProjectDto typeProjectToTypeProjectDto(TypeProject typeProject) {
        TypeProjectDto typeProjectDto = new TypeProjectDto();
        typeProjectDto.setId(typeProject.getId());
        typeProjectDto.setType(typeProject.getType());
        return typeProjectDto;
    }

    @Override
    public TypeProject typeProjectDtoToTypeProject(TypeProjectDto typeProjectDto) {
        TypeProject typeProject = new TypeProject();
        typeProject.setType(typeProjectDto.getType());
        return typeProject;
    }

    @Override
    public List<TypeProject> typeProjectDtosToTypeProjects(List<TypeProjectDto> typeProjectDtoList) {
        if (typeProjectDtoList == null) {
            return null;
        }
        List<TypeProject> typeProjectList = new ArrayList<>();
        for (TypeProjectDto typeProjectDto : typeProjectDtoList) {
            typeProjectList.add(typeProjectDtoToTypeProject(typeProjectDto));
        }
        return typeProjectList;
    }

    @Override
    public List<TypeProjectDto> typeProjectsToTypeProjectDtos(List<TypeProject> typeProjectList) {
        if (typeProjectList == null) {
            return null;
        }
        List<TypeProjectDto> typeProjectDtoList = new ArrayList<>();
        for (TypeProject typeProject : typeProjectList) {
            typeProjectDtoList.add(typeProjectToTypeProjectDto(typeProject));
        }
        return typeProjectDtoList;
    }

}
