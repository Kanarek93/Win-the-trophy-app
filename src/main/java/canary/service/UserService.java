package canary.service;

import canary.controller.HomeController;
import canary.domain.User;
import canary.domain.UserDto;
import canary.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerNewUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());

        String hashedPass = passwordEncoder.encode(userDto.getPassword());
        HomeController.LOGGER.info("zahashowalem haslo " + hashedPass);

        user.setPassword(hashedPass);

        User newUser = userRepository.save(user);

        return "Mam nowego użytkownika o id = " + newUser.getId();

    }

}
