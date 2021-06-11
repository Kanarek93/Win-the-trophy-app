package canary.domain.match;

import canary.domain.team.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hostTeam_id")
    private Team hostTeam;
    @ManyToOne
    @JoinColumn (name = "guestTeam_id")
    private Team guestTeam;

    //czy może to powinien być boolean?
    @ManyToOne
    @JoinColumn (name = "winner_id")
    private Team winner;
    private String winnerStatus;

    private Integer hostTeamGoals;
    private Integer guestTeamGoals;

    private LocalDateTime dateTime;
    //do sprawdzenia czy mecz już się odbył i czy wyniki zostały zapisane.
    private boolean isFinished;
    //która to kolejka
    private Integer matchDay;


}
