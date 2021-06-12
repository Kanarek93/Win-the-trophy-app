package canary.service.league;

import canary.domain.league.League;
import canary.domain.league.LeagueDto;

import java.util.List;
import java.util.Optional;

public interface LeagueService {

    List<League> getLeagues();

    League saveLeague(LeagueDto leagueDto);

    LeagueDto getLeagueFromApi(String code);

    Optional<League> getLeagueById(Long id);


}
