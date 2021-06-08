package canary.domain.league;

import canary.domain.team.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class League {

    @Id
    private long id;

    private String name;
    private String country;
    private String code;

    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn (name = "teams_id")
    private List<Team> teamList;

//    @ManyToMany
//    @JoinTable (name = "league_matches",
//    joinColumns = @JoinColumn(name = "league_id"),
//    inverseJoinColumns = @JoinColumn(name = "match_id"))
    //private List<Match> seasonMatchList;

    //ile jest kolejek
    private Integer matchweeks;
    //w zależności od ilości drużyn co tydzień odbywa się różna ilość meczy, do wyświetlania pewnie się przyda;
    private Integer matchesInWeek;

}
