package canary.domain.team;

import org.mapstruct.Mapper;

@Mapper
public interface TeamMapper {

    Team teamDtoToTeam(TeamDto teamDto);
    TeamDto teamToTeamDto(Team team);
}
