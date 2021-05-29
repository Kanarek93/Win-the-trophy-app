package canary.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Match {

    @Id
    private Long id;

    @ManyToOne
    private Team hostTeam;
    @ManyToOne
    private Team guestTeam;

    //czy może to powinien być boolean?
    @ManyToOne
    private Team winner;

    private Integer winGoals;
    private Integer lostGoals;

    private LocalDateTime dateTime;
    //do sprawdzenia czy mecz już się odbył i czy wyniki zostały zapisane.
    private boolean gotTheScore;
    //która to kolejka
    private Integer matchweek;


}
