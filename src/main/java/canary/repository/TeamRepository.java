package canary.repository;

import canary.domain.league.League;
import canary.domain.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findByName(String name);

    List<Team> findAllByLeagueId(long id);
    
}
