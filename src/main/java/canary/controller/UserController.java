package canary.controller;


import canary.domain.team.Team;
import canary.domain.user.User;
import canary.service.team.TeamService;
import canary.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService us;
    private final TeamService ts;

    @PostMapping("/user/chooseteam")
    public String chooseTeam(Team team){
        User current = us.getCurrentUser();
        Team toSave = ts.getByName(team.getName());
        us.saveTeam(toSave);
        LOGGER.info("Przypisałem użytkownikowi " + current.getName() + " zespół " + toSave.getTla());
        return "redirect:/user";
    }

    @GetMapping("/user")
    public String saveFavTeam(Model model){
        User current = us.getCurrentUser();
        if(current.getFavTeam() == null){
            return "redirect:/user/chooseleague";
        }
        else {
            LOGGER.info("Current user favTeam: " + current.getFavTeam().getName());
            model.addAttribute("user", current);
            model.addAttribute("totalMatchDays", current.getFavTeam().getLeague().getMatchDaysInTotal());
         return "dashboard";
        }
    }


}
