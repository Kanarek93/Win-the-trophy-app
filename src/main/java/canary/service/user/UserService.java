package canary.service.user;

import canary.domain.team.Team;
import canary.domain.user.User;
import canary.domain.user.UserDto;


public interface UserService {

    User findByUserName(String name);

    User registerUser(UserDto user);

    User getCurrentUser();

    User saveTeam(Team team);
}
