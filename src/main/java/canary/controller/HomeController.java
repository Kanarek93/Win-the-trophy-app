package canary.controller;

import canary.domain.User;
import canary.domain.UserDto;
import canary.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@RequestMapping("/wtt")

@Controller
public class HomeController {

    public static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String loadLoginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String loadRegisterPage(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String registrationForm(@ModelAttribute ("user") @Valid User user){
        LOGGER.info("Odebrałem usera " + user.getName());

        userService.saveUser(user);

        return "successfully registered";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
}
