package canary.service;

import canary.domain.league.League;
import canary.domain.league.LeagueDto;
import canary.domain.league.LeagueMapper;
import canary.repository.LeagueRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeagueServiceImpl {

    private LeagueMapper mapper = Mappers.getMapper(LeagueMapper.class);

    private final LeagueDataClient ldc;
    private final LeagueRepository lr;

    public List<League> getLeagues(){
        return lr.findAll();
    }

    public League saveLeague(LeagueDto leagueDto){
        League leagueToSave = mapper.leagueDtoToLeague(leagueDto);
        return lr.save(leagueToSave);
    }

    public LeagueDto getLeagueFromApi(String code){
        return ldc.getLeagueData(code);
    }

}
