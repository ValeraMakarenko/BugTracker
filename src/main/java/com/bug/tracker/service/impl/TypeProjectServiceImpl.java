package com.bug.tracker.service.impl;

import com.bug.tracker.dao.TypeProjectDao;
import com.bug.tracker.dto.TypeProjectDto;
import com.bug.tracker.mapper.TypeProjectMapper;
import com.bug.tracker.model.TypeProject;
import com.bug.tracker.service.TypeProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("typeProjectService")
@Transactional
public class TypeProjectServiceImpl implements TypeProjectService {

    @Autowired
    private TypeProjectDao dao;
    @Autowired
    private TypeProjectMapper typeProjectMapper;

    @Override
    public List<TypeProjectDto> findAll() {
        return typeProjectMapper.typeProjectsToTypeProjectDtos(dao.findAll());
    }

    @Override
    public TypeProjectDto findByType(String type) {
        return typeProjectMapper.typeProjectToTypeProjectDto(dao.findByType(type));
    }

    @Override
    public TypeProject findById(int id) {
        return dao.findById(id);
    }
}
