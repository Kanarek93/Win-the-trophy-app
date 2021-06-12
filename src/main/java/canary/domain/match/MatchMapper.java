package canary.domain.match;

import canary.domain.team.Team;
import canary.domain.team.TeamMapper;
import canary.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MatchMapper {

    private final TeamRepository tr;
    private final TeamMapper mapper;

    public Match MatchDtoToMatch(MatchDto matchDto){
        Match match = new Match();

        //takie co tylko setterami się daje
        match.setId(matchDto.getId());
        match.setHostTeamGoals(matchDto.getScore().getFullTime().getHomeTeam());
        match.setGuestTeamGoals(matchDto.getScore().getFullTime().getAwayTeam());
        match.setUtcDT(matchDto.getUtcDate());
        match.setMatchDay(matchDto.getMatchday());
        match.setWinnerStatus(matchDto.getScore().getWinner());

        //status
        String status = matchDto.getStatus();
        if ("FINISHED".equals(status)){
            match.setFinished(true);
        }
        else {
            match.setFinished(false);
        }

        //zespoły z TeamDto
        Team hostTeamFromDto = mapper.teamDtoToTeam(matchDto.getHomeTeam());
        match.setHostTeam(tr.findByName(hostTeamFromDto.getName()));

        Team guestTeamFromDto = mapper.teamDtoToTeam(matchDto.getAwayTeam());
        match.setGuestTeam(tr.findByName(guestTeamFromDto.getName()));

        //zwycięzca - jeżeli jest remis to pole zostaje puste
        if ("AWAY_TEAM".equals(matchDto.getScore().getWinner())) {
            match.setWinner(match.getGuestTeam());
        } else if("HOME_TEAM".equals(matchDto.getScore().getWinner())){
            match.setWinner(match.getHostTeam());
        }


        return match;
    }
}
