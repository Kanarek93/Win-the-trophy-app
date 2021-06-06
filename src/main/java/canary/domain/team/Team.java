package canary.domain.team;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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
