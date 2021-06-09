package canary.domain.team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

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

    //Inne
    private Integer points;

    private Integer matchesWon;
    private Integer matchesLost;
    private Integer matchesDraw;

    private Integer goals;
    private Integer lostGoals;
}
