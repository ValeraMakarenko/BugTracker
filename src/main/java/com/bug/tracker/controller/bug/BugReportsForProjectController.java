package com.bug.tracker.controller.bug;

import com.bug.tracker.controller.AbsController;
import com.bug.tracker.model.BugReportForViewKotlin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BugReportsForProjectController extends AbsController {

    @RequestMapping(value = { "/bugreport-list-{id}" }, method = RequestMethod.GET)
    public String bugReportList(@PathVariable int id, ModelMap model) {
        List<BugReportForViewKotlin> bugReportForViewKotlins = bugReportService.findBugReportsForProject(id);
        model.addAttribute("bugReports", bugReportForViewKotlins);
        return "bugreportlist";
    }

}