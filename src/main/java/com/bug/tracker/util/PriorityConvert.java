package com.bug.tracker.util;

import com.bug.tracker.model.Priority;
import com.bug.tracker.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PriorityConvert implements Converter<Object, Priority> {

    @Autowired
    PriorityService priorityService;

    public Priority convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        Priority priority= priorityService.findById(id);
        System.out.println("Priority : "+priority);
        return priority;
    }
}
