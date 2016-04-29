package com.bug.tracker.controller.project;

import com.bug.tracker.controller.AbsController;
import com.bug.tracker.model.ProjectForViewKotlin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DetailsProjectController extends AbsController {

    @RequestMapping(value = { "/details-project-{id}" }, method = RequestMethod.GET)
    public String editProject(@PathVariable int id, ModelMap model) {
        ProjectForViewKotlin projectForViewKotlin = projectMapper.ProjectDtoToProjectForViewKotlin(projectService.findById(id));
        model.addAttribute("project", projectForViewKotlin);
        return "detailsproject";
    }

}
