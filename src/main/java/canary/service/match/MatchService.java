package canary.service.match;

import canary.domain.match.Match;


import java.util.List;

public interface MatchService {

    Match saveMatch(Match match);

    List<Match> getMatchesFromAPi(String code);

}
