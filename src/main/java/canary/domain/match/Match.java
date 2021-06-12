package canary.domain.match;

import canary.domain.league.League;
import canary.domain.team.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="matches")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private League league;

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

    private LocalDateTime utcDT;
    //do sprawdzenia czy mecz już się odbył i wyniki zostały zapisane
    private boolean isFinished;
    //która to kolejka
    private Integer matchDay;

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", league=" + league.getName() +
                ", hostTeam=" + hostTeam.getName() +
                ", guestTeam=" + guestTeam.getName() +
                ", winner=" + winner.getName() +
                ", winnerStatus='" + winnerStatus + '\'' +
                ", hostTeamGoals=" + hostTeamGoals +
                ", guestTeamGoals=" + guestTeamGoals +
                ", utcDT=" + utcDT +
                ", isFinished=" + isFinished +
                ", matchDay=" + matchDay +
                '}';
    }
}
