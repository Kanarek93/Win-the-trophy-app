package canary.service.team;

import canary.domain.team.Team;
import canary.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository tr;

    @Override
    public Team getByName(String name) {
        return tr.findByName(name);
    }
}
