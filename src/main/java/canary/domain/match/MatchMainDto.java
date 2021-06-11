package canary.domain.match;

import canary.domain.league.LeagueDto;
import lombok.Data;

import java.util.List;

@Data
public class MatchMainDto {

        private long id;
        private List<MatchDto> matches;
        private LeagueDto competition;

}
