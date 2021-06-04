package canary.controller;

import canary.domain.User;
import canary.domain.UserDto;
import canary.service.UserService;
import canary.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RequestMapping("/wtt")
@Controller
public class HomeController {

    public static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

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
    @ResponseBody
    public String registrationForm(@ModelAttribute ("user") @Valid UserDto user,
                                         HttpRequest request,
                                         Error errors){
        LOGGER.info("Odebrałem usera " + user.getName());

        //userService.saveUser(user);

        return "successfully registered";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "login";
    }
}
