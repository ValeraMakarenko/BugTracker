package com.bug.tracker.controller.project;

import com.bug.tracker.controller.AbsController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeleteProjectController extends AbsController {

    @RequestMapping(value = { "/delete-project-{id}" }, method = RequestMethod.GET)
    public String deleteProject(@PathVariable int id) {
        projectService.deleteProjectById(id);
        return "redirect:/projectlist";
    }

}
