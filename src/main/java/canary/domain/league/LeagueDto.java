package canary.domain.league;

import canary.domain.team.Team;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class LeagueDto {

    private long id;
    private String name;
    private String code;

    private List<Team> teams;

}
