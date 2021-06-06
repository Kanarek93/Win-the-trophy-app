package canary.service.league;

import canary.domain.league.League;
import canary.domain.league.LeagueDto;

import java.util.List;

public interface LeagueService {

    public List<League> getLeagues();

    public League saveLeague(LeagueDto leagueDto);

    public LeagueDto getLeagueFromApi(String code);


}
