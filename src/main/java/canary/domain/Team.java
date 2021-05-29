package canary.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer points;

    private Integer matchesWon;
    private Integer matchesLost;
    private Integer matchesDraw;

    private Integer goals;
    private Integer lostGoals;


}
