package canary.domain.team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Team {

    //TeamDTO
    @Id
    private Long id;
    private String name;
    private String tla; //skrót meczowy
    private String crestUrl; //logo

    //Inne
    private Integer points;

    private Integer matchesWon;
    private Integer matchesLost;
    private Integer matchesDraw;

    private Integer goals;
    private Integer lostGoals;
}
