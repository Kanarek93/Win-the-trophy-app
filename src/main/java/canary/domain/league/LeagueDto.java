package canary.domain.league;

import canary.domain.team.Team;
import lombok.Data;

import java.util.List;

@Data
public class LeagueDto {

    private long id;
    private String name;
    private String code;

    private List<Team> teams;
    private Integer counts;

}
