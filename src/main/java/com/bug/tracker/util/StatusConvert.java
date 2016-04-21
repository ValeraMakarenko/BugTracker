package com.bug.tracker.util;

import com.bug.tracker.model.Status;
import com.bug.tracker.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StatusConvert implements Converter<Object, Status> {

    @Autowired
    StatusService statusService;

    public Status convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        Status status= statusService.findById(id);
        System.out.println("Status : "+status);
        return status;
    }

}
