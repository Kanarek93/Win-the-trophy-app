package canary.service.match;

import canary.domain.match.Match;
import canary.repository.MatchRepository;
import canary.service.DataClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService{

    private final MatchRepository mr;
    private final DataClient dc;

    @Override
    public Match saveMatch(Match match) {
        return mr.save(match);
    }

    @Override
    public List<Match> getMatchesFromAPi(String code) {
        return dc.getLeagueMatches(code);
    }

}
