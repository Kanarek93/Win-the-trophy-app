package canary.domain.league;

import org.mapstruct.Mapper;

@Mapper
public interface LeagueMapper {

    League leagueDtoToLeague(LeagueDto leagueDto);

    LeagueDto leagueToLeagueDto(League league);
}
