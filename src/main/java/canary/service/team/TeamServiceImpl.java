package canary.service.team;

import canary.domain.league.League;
import canary.domain.match.Match;
import canary.domain.team.Team;
import canary.repository.MatchRepository;
import canary.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Log
public class TeamServiceImpl implements TeamService {

    private final TeamRepository tr;
    private final MatchRepository mr;

    @Override
    public Team getByName(String name) {
        return tr.findByName(name);
    }

    @Override
    public Team getStats(Long id, Integer matchday) {
        Team t = tr.findById(id).get();
        log.info("Szukam meczów dla zespołu: " + t.getName());
        List<Match> matchesAsGuest = mr.findAllByGuestTeamAndMatchDayLessThan(t,  matchday);
        List<Match> matchesAsHost = mr.findAllByHostTeamAndMatchDayLessThan(t, matchday);

        int matchesWon =0, matchesLost =0, matchesDraw =0, goals=0, lostGoals=0;

        for (Match m : matchesAsGuest){

            if("DRAW".equals(m.getWinnerStatus())){
                matchesDraw++;
            } else if (m.getWinner().equals(t)){
                matchesWon++;
             } else {
                matchesLost++;
            }

            goals += m.getGuestTeamGoals();
            lostGoals += m.getHostTeamGoals();
        }

        for (Match m : matchesAsHost){
            if("DRAW".equals(m.getWinnerStatus())){
                matchesDraw++;
            } else if(m.getWinner().equals(t)){
                matchesWon++;
            } else {
                matchesLost++;
            }

            goals += m.getHostTeamGoals();
            lostGoals += m.getGuestTeamGoals();
        }

        t.setMatchesWon(matchesWon);
        t.setMatchesDraw(matchesDraw);
        t.setMatchesLost(matchesLost);
        t.setGoals(goals);
        t.setLostGoals(lostGoals);
        t.setPoints(matchesWon*3+matchesDraw);

        return t;
    }

    @Override
    public List<Team> getTeamsFromLeague(League league) {
        return tr.findAllByLeagueId(league.getId());
    }

    @Override
    public Team saveTeam(Team team) {
        return tr.save(team);
    }
}
