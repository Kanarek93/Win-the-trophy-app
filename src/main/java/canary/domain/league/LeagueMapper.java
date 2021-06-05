package canary.domain.league;

import canary.domain.league.League;
import canary.domain.league.LeagueDto;
import org.mapstruct.Mapper;

@Mapper
public interface LeagueMapper {

    League leagueDtoToLeague(LeagueDto leagueDto);
    LeagueDto leagueToLeagueDto(League league);
}
