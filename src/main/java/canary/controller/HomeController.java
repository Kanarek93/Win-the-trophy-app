package canary.controller;

import canary.domain.user.User;
import canary.domain.user.UserDto;
import canary.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String loadRegisterPage(WebRequest request, Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register";
    }

    @PostMapping("/register")
    public String registrationForm(@ModelAttribute ("user") @Valid UserDto user,
                                         HttpServletRequest request,
                                         Errors errors,
                                   Model model){
        try {
            User registered = userService.registerUser(user);
        } catch (Exception uaeEx) {
           model.addAttribute("message", "Użytkownik o tym loginie już istnieje!");
            return "403";
        }

        return "redirect:/user";
    }


}
