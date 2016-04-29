package com.bug.tracker.controller.project;

import com.bug.tracker.controller.AbsController;
import com.bug.tracker.model.ProjectForViewKotlin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ListProjectController extends AbsController {

    @RequestMapping(value = "/projectlist", method = RequestMethod.GET)
    public String projectList(ModelMap model) {
        List<ProjectForViewKotlin> projectForViewKotlinList = projectService.findAll();
        model.addAttribute("projects", projectForViewKotlinList);
        return "projectlist";
    }
}
