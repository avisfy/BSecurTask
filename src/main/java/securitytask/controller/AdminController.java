package securitytask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import securitytask.entity.User;
import securitytask.services.UserService;

import java.util.List;

@Controller
public class AdminController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/admin")
    public ModelAndView showAdmin() {
        List<User> allUsers = userService.findAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpage");
        modelAndView.addObject("allUsers", allUsers);
        return modelAndView;
    }
}
