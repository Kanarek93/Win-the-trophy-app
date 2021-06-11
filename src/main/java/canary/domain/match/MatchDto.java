package canary.domain.match;

import canary.domain.team.TeamDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MatchDto {

    private long id;
    private LocalDateTime utcDate;
    private int matchday;
    private ScoreDto score;
    private TeamDto homeTeam;
    private TeamDto awayTeam;
    private String status;

}
