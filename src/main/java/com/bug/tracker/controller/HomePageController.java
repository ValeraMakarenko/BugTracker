package com.bug.tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController extends AbsController {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Hi, Welcome to my site");
        return "welcome";
    }

    @RequestMapping(value = {"/header"}, method = RequestMethod.GET)
    public String header(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "header";
    }

}
