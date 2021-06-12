package canary.domain.match;

import canary.domain.league.League;
import canary.domain.league.LeagueMapper;
import canary.repository.LeagueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MatchMainMapper {

    private final MatchMapper matchMapper;
    private final LeagueMapper leagueMapper;
    private final LeagueRepository leagueRepository;

    public List<Match> getListOfMatches(MatchMainDto matchMainDto){
        League leagueFromDto = leagueMapper.leagueDtoToLeague(matchMainDto.getCompetition());
        League leagueToSet = leagueRepository.findByName(leagueFromDto.getName());

        return matchMainDto.getMatches().stream()
                .map(matchDto -> matchMapper.MatchDtoToMatch(matchDto))
                .peek(match -> match.setLeague(leagueToSet))
                .collect(Collectors.toList());
    }

}
