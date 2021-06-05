package canary.controller;

import canary.domain.league.League;
import canary.domain.league.LeagueDto;
import canary.repository.LeagueRepository;
import canary.service.LeagueDataClient;
import canary.service.LeagueServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class LeagueController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LeagueController.class);

    private final LeagueServiceImpl lsi;

    @GetMapping("/leagues/{code}")
    @ResponseBody
    public String saveLeagues(@PathVariable String code){
        LeagueDto downloadedLeague = lsi.getLeagueFromApi(code);
        lsi.saveLeague(downloadedLeague);
        LOGGER.info("Pobrałem ligę " + code);
        return downloadedLeague.toString();
    }

    @GetMapping("/user/choose")
    public String showLeagues(){
        return "/user/leagues";
    }

    @ModelAttribute("ligi")
    public List<League> leagues(){
        return lsi.getLeagues();
    }


}
