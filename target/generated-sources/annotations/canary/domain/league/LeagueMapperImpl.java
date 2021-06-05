package canary.domain.league;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-05T09:12:16+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.2 (Oracle Corporation)"
)
public class LeagueMapperImpl implements LeagueMapper {

    @Override
    public League leagueDtoToLeague(LeagueDto leagueDto) {
        if ( leagueDto == null ) {
            return null;
        }

        League league = new League();

        league.setId( leagueDto.getId() );
        league.setName( leagueDto.getName() );
        league.setCode( leagueDto.getCode() );

        return league;
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
