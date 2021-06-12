package canary.domain.league;

import canary.domain.league.League.LeagueBuilder;
import canary.domain.team.Team;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-12T05:28:48+0200",
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
        if ( leagueDto.getCounts() != null ) {
            league.matchDaysInTotal( LeagueMapper.countToMatchDays( leagueDto.getCounts().intValue() ) );
        }
        league.id( leagueDto.getId() );
        league.name( leagueDto.getName() );
        league.code( leagueDto.getCode() );

        return league.build();
    }
}
