package canary.service.team;


import canary.domain.team.Team;

public interface TeamService {

    Team getByName(String name);
}
