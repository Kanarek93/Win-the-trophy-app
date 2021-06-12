package canary.domain.league;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper (componentModel = "spring")
public interface LeagueMapper {

    @Mappings({ @Mapping(target="teamList", source="leagueDto.teams"),
    @Mapping(target = "matchDaysInTotal", source = "leagueDto.counts", qualifiedByName = "countToMatchDays"), })
    League leagueDtoToLeague(LeagueDto leagueDto);

    @Named("countToMatchDays")
    public static Integer countToMatchDays(int count) {
        return (count-1)*2;
    }

}
