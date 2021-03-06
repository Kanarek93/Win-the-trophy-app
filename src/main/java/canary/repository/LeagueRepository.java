package canary.repository;

import canary.domain.league.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository <League, Long> {

    League findByName(String name);

}
