package canary.controller;

import canary.domain.league.League;
import canary.domain.league.LeagueDto;
import canary.domain.team.Team;
import canary.service.league.LeagueServiceImpl;
import canary.statics.AvailableLeauges;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class LeagueController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeagueController.class);

    private final LeagueServiceImpl lsi;


    //Pobierać do bazy danych mogą tylko Admini
    //Pobranie konkretnej ligi i zapis do bazy danych
    @GetMapping("/admin/leagues/{code}")
    @ResponseBody
    public String saveLeague(@PathVariable String code){
        LeagueDto downloadedLeague = lsi.getLeagueFromApi(code);
        lsi.saveLeague(downloadedLeague);
        LOGGER.info("Pobrałem ligę " + code);
        return downloadedLeague.toString();
    }

    //Pobieranie wszystkich dostępnych lig
    //------ ????????? Czy muszę sprawdzać czy już taka liga jest ???????? --------
    @GetMapping("/admin/leagues")
    public String saveLeagues(){
        for(AvailableLeauges av : AvailableLeauges.values()){
            LOGGER.info(saveLeague(av.toString()));
        }
        return "Pobrano dane o " + AvailableLeauges.values().length + " ligach";
    }

    @GetMapping("/user/chooseleague")
    public String showLeagues(Model model){
        model.addAttribute("league", new League());
        return "/user/leagues";
    }

    @PostMapping("/user/chooseleague")
    public String chooseLeague(Model model, League league){
        League downloadedLeague = lsi.getLeagueByName(league.getName());
        model.addAttribute("teams", downloadedLeague.getTeamList());
        return "user/chooseFavTeam";
    }

    @PostMapping("/user/chooseteam")
    @ResponseBody
    public String chooseTeam(Team team){
        return "Wybierz";
    }

    @ModelAttribute("leagues")
    public List<League> leagues(){
        return lsi.getLeagues();
    }


}
