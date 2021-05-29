package canary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class LeagueController {

    @GetMapping("/leagues")
    @ResponseBody
    public String getLeagues(){
        return "";
    }
    
}
