package securitytask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import securitytask.entity.User;
import securitytask.services.UserService;

import java.security.Principal;

@Controller
public class UserpageController {
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public ModelAndView showUserpage(Principal principal) {
        String name = principal.getName();
        String role = userService.getUserByLogin(name).getRole().getRole();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userpage");
        modelAndView.addObject("username", name);
        modelAndView.addObject("userrole", role);
        return modelAndView;
    }
}
