package canary.service;

import canary.domain.User;

public interface UserServiceInterface {

    User findByUserName(String name);

    void saveUser(User user);
}
