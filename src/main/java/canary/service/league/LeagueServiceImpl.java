package canary.service.league;

import canary.domain.league.League;
import canary.domain.league.LeagueDto;
import canary.domain.league.LeagueMapper;
import canary.repository.LeagueRepository;

import canary.service.DataClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class LeagueServiceImpl implements LeagueService{

    private final LeagueMapper leagueMapper;
    private final DataClient ldc;
    private final LeagueRepository lr;

    public List<League> getLeagues(){
        return lr.findAll();
    }

    public League saveLeague(LeagueDto leagueDto){
        League leagueToSave = leagueMapper.leagueDtoToLeague(leagueDto);
        return lr.save(leagueToSave);
    }

    public LeagueDto getLeagueFromApi(String code){
        return ldc.getLeagueData(code);
    }

    public League getLeagueByName(String name){
        return lr.findByName(name);
    }

    @Override
    public Optional<League> getLeagueById(Long id) {
        return lr.findById(id);
    }
}
