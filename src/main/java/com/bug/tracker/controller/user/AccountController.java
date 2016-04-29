package com.bug.tracker.controller.user;

        import com.bug.tracker.controller.AbsController;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.ModelMap;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController extends AbsController {

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String accPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "account";
    }
}
