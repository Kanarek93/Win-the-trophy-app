package canary.service;

import canary.domain.user.User;
import canary.domain.user.UserDto;


public interface UserService {

    User findByUserName(String name);

    User registerUser(UserDto user);
}
