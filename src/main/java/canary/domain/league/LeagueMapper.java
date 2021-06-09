package canary.domain.league;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper (componentModel = "spring")
public interface LeagueMapper {

    @Mappings({ @Mapping(target="teamList", source="leagueDto.teams")})
    League leagueDtoToLeague(LeagueDto leagueDto);

    @Mappings({ @Mapping(target="teams", source="league.teamList")})
    LeagueDto leagueToLeagueDto(League league);
}
