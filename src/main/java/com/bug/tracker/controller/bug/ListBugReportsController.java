package com.bug.tracker.controller.bug;

import com.bug.tracker.controller.AbsController;
import com.bug.tracker.model.BugReportForViewKotlin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ListBugReportsController extends AbsController {

    @RequestMapping(value = "/bugreportlist", method = RequestMethod.GET)
    public String bugReportList(ModelMap model) {
        List<BugReportForViewKotlin> bugReportForViewKotlins = bugReportService.findAll();
        model.addAttribute("bugReports", bugReportForViewKotlins);
        return "bugreportlist";
    }

}
