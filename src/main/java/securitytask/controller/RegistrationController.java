package securitytask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import securitytask.entity.Role;
import securitytask.entity.User;
import securitytask.services.UserService;

import java.util.List;

@Controller
public class RegistrationController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("user", new User());
//        modelAndView.setViewName("registration");
//        return modelAndView;
    }

    @PostMapping(value = "/register" )
    public ModelAndView addUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        if (!user.getPassword().equals(user.getPasswordConfirm())){
            modelAndView.addObject("passwordError", "Password not equals");
            modelAndView.setViewName("registration");
        } else {
            userService.addUser(user, "ROLE_USER");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
}
