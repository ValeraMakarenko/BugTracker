package com.bug.tracker.controller.bug;

import com.bug.tracker.controller.AbsController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeleteBugReportController extends AbsController {

    @RequestMapping(value = { "/delete-bugreport-{id}" }, method = RequestMethod.GET)
    public String deleteBugReport(@PathVariable int id) {
        bugReportService.deleteBugReportById(id);
        return "redirect:/home";
    }

}
