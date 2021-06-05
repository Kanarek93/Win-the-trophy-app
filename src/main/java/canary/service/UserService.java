package canary.service;

import canary.domain.User;
import canary.domain.UserDto;

public interface UserService {

    User findByUserName(String name);

    User registerUser(UserDto user);
}
