 package canary.repository;

import canary.domain.match.Match;
import canary.domain.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


 public interface MatchRepository extends JpaRepository<Match, Long> {

    Integer countMatchByWinner(Team team);

    //wszystkie mecze zespołu
     List<Match> findAllByGuestTeamAndMatchDayLessThan(Team team, Integer matchDay);
     List<Match> findAllByHostTeamAndMatchDayLessThan(Team team, Integer matchDay);

}
