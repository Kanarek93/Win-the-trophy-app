package canary.domain.league;

import canary.domain.league.League.LeagueBuilder;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-06T22:49:05+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.2 (Oracle Corporation)"
)
public class LeagueMapperImpl implements LeagueMapper {

    @Override
    public League leagueDtoToLeague(LeagueDto leagueDto) {
        if ( leagueDto == null ) {
            return null;
        }

        LeagueBuilder league = League.builder();

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

        leagueDto.setId( league.getId() );
        leagueDto.setName( league.getName() );
        leagueDto.setCode( league.getCode() );

        return leagueDto;
    }
}
