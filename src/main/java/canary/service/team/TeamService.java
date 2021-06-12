package canary.service.team;


import canary.domain.league.League;
import canary.domain.team.Team;

import java.util.List;

public interface TeamService {

    Team getByName(String name);

    Team getStats(Long id, Integer matchday);

    List<Team> getTeamsFromLeague(League league);

    Team saveTeam(Team team);
}
