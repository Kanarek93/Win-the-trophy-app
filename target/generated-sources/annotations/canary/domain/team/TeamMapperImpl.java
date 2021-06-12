package canary.domain.team;

import canary.domain.team.Team.TeamBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-12T05:28:48+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.2 (Oracle Corporation)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public Team teamDtoToTeam(TeamDto teamDto) {
        if ( teamDto == null ) {
            return null;
        }

        TeamBuilder team = Team.builder();

        team.id( teamDto.getId() );
        team.name( teamDto.getName() );
        team.tla( teamDto.getTla() );
        team.crestUrl( teamDto.getCrestUrl() );

        return team.build();
    }

    @Override
    public TeamDto teamToTeamDto(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamDto teamDto = new TeamDto();

        teamDto.setId( team.getId() );
        teamDto.setName( team.getName() );
        teamDto.setTla( team.getTla() );
        teamDto.setCrestUrl( team.getCrestUrl() );

        return teamDto;
    }
}
