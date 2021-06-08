package canary.domain.league;

import canary.domain.team.Team;
import canary.domain.team.TeamDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class LeagueTeamDto {

    private List<TeamDto> teams;
}
