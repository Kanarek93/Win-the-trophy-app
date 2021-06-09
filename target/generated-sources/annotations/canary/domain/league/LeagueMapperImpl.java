package canary.domain.league;

import canary.domain.league.League.LeagueBuilder;
import canary.domain.team.Team;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-09T22:22:01+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.2 (Oracle Corporation)"
)
@Component
public class LeagueMapperImpl implements LeagueMapper {

    @Override
    public League leagueDtoToLeague(LeagueDto leagueDto) {
        if ( leagueDto == null ) {
            return null;
        }

        LeagueBuilder league = League.builder();

        List<Team> list = leagueDto.getTeams();
        if ( list != null ) {
            league.teamList( new ArrayList<Team>( list ) );
        }
        league.id( leagueDto.getId() );
        league.name( leagueDto.getName() );
        league.code( leagueDto.getCode() );

        return league.build();
    }

    @Override
    public LeagueDto leagueToLeagueDto(League league) {
        if ( league == null ) {
            return null;
        }

        LeagueDto leagueDto = new LeagueDto();

        List<Team> list = league.getTeamList();
        if ( list != null ) {
            leagueDto.setTeams( new ArrayList<Team>( list ) );
        }
        leagueDto.setId( league.getId() );
        leagueDto.setName( league.getName() );
        leagueDto.setCode( league.getCode() );

        return leagueDto;
    }
}
