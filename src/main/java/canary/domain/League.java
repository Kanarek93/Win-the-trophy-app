package canary.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String country;

    @OneToMany
    private List<Team> teamList;

    @ManyToMany
    private List<Match> seasonMatchList;

    @ManyToOne
    private League league; //?? Czy to musi tutaj być?

    //ile jest kolejek
    private Integer matchweeks;
    //w zależności od ilości drużyn co tydzień odbywa się różna ilość meczy, do wyświetlania pewnie się przyda;
    private Integer matchesInWeek;
}
