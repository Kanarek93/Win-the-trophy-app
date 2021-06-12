package canary.controller;

import canary.domain.league.League;
import canary.domain.league.LeagueDto;
import canary.domain.match.Match;
import canary.domain.team.Team;
import canary.domain.user.User;
import canary.service.league.LeagueServiceImpl;
import canary.service.match.MatchServiceImpl;
import canary.service.team.TeamServiceImpl;
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
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class LeagueController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeagueController.class);

    private final LeagueServiceImpl lsi;
    private final MatchServiceImpl msi;
    private final TeamServiceImpl tsi;


    //Pobierać do bazy danych mogą tylko Admini
    //Pobranie konkretnej ligi i zapis do bazy danych
    @GetMapping("/admin/leagues/{code}")
    @ResponseBody
    public String saveLeague(@PathVariable String code){
        try {
            LeagueDto downloadedLeague = lsi.getLeagueFromApi(code);
            lsi.saveLeague(downloadedLeague);
            LOGGER.info("Pobrałem ligę " + code);
            return downloadedLeague.toString();
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode().value() == 429) {
                LOGGER.error("Za dużo zapytań do bazy");
                return "429";
            } else {
                return "error";
            }
        }
    }

    //Pobieranie wszystkich dostępnych lig
    @GetMapping("/admin/leagues")
    public String saveLeagues(){

        try {
            for (AvailableLeauges av : AvailableLeauges.values()) {
                LOGGER.info(saveLeague(av.toString()));
            }
            return "Pobrano dane o " + AvailableLeauges.values().length + " ligach";
        } catch (HttpClientErrorException ex){
            if (ex.getStatusCode().value() == 429){
                LOGGER.error("Za dużo zapytań do bazy");
                return "429";
            }
            else {
                return "error";
            }
        }
    }

    @GetMapping("/admin/matches/{code}")
    @ResponseBody
    public String saveMatches(@PathVariable String code){
        try {
               List<Match> matches = msi.getMatchesFromAPi(code.toUpperCase());
                LOGGER.info("Pobrałem mecze z ligi " +  code);
                for (Match m : matches){
                    msi.saveMatch(m);
                    //LOGGER.info("Zapisałem do bazy mecz o id = " + m.getId());
                }
            return "Pobrano dane o meczach" + code + " ligach";
        } catch (HttpClientErrorException ex){
            if (ex.getStatusCode().value() == 429){
                LOGGER.error("Za dużo zapytań do bazy");
                return "429";
            }
            else {
                return "error";
            }
        }
    }

    @GetMapping("/user/chooseleague")
    public String showLeagues(Model model){
        model.addAttribute("league", new League());
        return "leagues";
    }

    @PostMapping("/user/chooseleague")
    public String chooseLeague(Model model, League league){
        League downloadedLeague = lsi.getLeagueByName(league.getName());
        model.addAttribute("teams", downloadedLeague.getTeamList());
        model.addAttribute("team", new Team());
        return "chooseFavTeam";
    }

    @GetMapping("/user/leagueteams/{id}")
    public String getMatchStatsAndSave(@PathVariable Long id){
        League league = lsi.getLeagueById(id).get();
        List<Team> leagueTeams = tsi.getTeamsFromLeague(league);
        for (Team t : leagueTeams){
            Team team = tsi.getStats(t.getId(), league.getMatchDaysInTotal());
            tsi.saveTeam(team);
        }
        return "redirect:/user";
    }

    @PostMapping("/user/couldwin")
    public String checkIfCouldWin(User user, Integer md, Model model){
        int maxPoints = 0;
        int favTeamPoints = user.getFavTeam().getPoints();
        int matchDaysInTotal = user.getFavTeam().getLeague().getMatchDaysInTotal();

        League userLeague = lsi.getLeagueById(user.getFavTeam().getLeague().getId()).get();
        List<Team> teams = tsi.getTeamsFromLeague(userLeague);
        for (Team t :teams){
            tsi.getStats(t.getId(), md);
            if (maxPoints < t.getPoints()){
                maxPoints = t.getPoints();
            }
        }

        if ((maxPoints - favTeamPoints) == 0) {
            model.addAttribute("message", "Twój zespół jest na pierwszym miejscu!");
        } else if((maxPoints - favTeamPoints) > (matchDaysInTotal - md)*3) {
            model.addAttribute("message", "Twój zespół już nie może wygrać :(");
        } else {
            model.addAttribute("message", "Wciąż są szanse!");
        }

        return "couldWin";
    }



    @ModelAttribute("leagues")
    public List<League> leagues(){
        return lsi.getLeagues();
    }


}
