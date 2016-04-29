package com.bug.tracker.service;

import com.bug.tracker.dto.TypeProjectDto;
import com.bug.tracker.model.TypeProject;

import java.util.List;

public interface TypeProjectService {

    List<TypeProjectDto> findAll();

    TypeProjectDto findByType(String type);

    TypeProject findById(int id);
}
