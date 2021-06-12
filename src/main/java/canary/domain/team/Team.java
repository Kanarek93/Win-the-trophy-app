package canary.domain.team;

import canary.domain.league.League;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Team {

    //TeamDTO
    @Id
    private Long id;
    private String name;
    private String tla; //skrót meczowy
    private String crestUrl; //logo
    @ManyToOne (fetch = FetchType.EAGER)
    private League league;

    //Inne
    private Integer points;

    private Integer matchesWon;
    private Integer matchesLost;
    private Integer matchesDraw;

    private Integer goals;
    private Integer lostGoals;

}
