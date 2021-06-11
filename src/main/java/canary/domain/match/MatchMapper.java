package canary.domain.match;

import canary.domain.team.TeamMapper;
import canary.repository.TeamRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class MatchMapper {

    private final TeamRepository tr;
    private final TeamMapper mapper;

    public Match MatchDtoToMatch(MatchDto matchDto){
        Match match = new Match();

        //takie co tylko setterami się daje
        match.setId(matchDto.getId());
        match.setHostTeamGoals(matchDto.getScore().getFullTime().getHomeTeam());
        match.setGuestTeamGoals(matchDto.getScore().getFullTime().getAwayTeam());
        match.setDateTime(matchDto.getUtcDate());
        match.setMatchDay(matchDto.getMatchday());

        //status
        String status = matchDto.getStatus();
        if ("FINISHED".equals(status)){
            match.setFinished(true);
        }
        else {
            match.setFinished(false);
        }

        //zespoły z TeamDto



        return match;
    }
}
