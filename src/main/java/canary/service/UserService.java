package canary.service;

import canary.domain.User;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);
}
