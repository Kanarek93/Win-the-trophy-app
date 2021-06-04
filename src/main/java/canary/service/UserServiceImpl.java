package canary.service;

import canary.controller.HomeController;
import canary.domain.Role;
import canary.domain.User;
import canary.repository.RoleRepository;
import canary.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findByUserName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void saveUser(User user) {
        String pass = user.getPassword();
        user.setPassword(passwordEncoder.encode(pass));
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
        HomeController.LOGGER.info("Zapisałem nowego użytkownika");
    }

    /*
    public String registerNewUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());

        String hashedPass = passwordEncoder.encode(userDto.getPassword());
        HomeController.LOGGER.info("zahashowalem haslo " + hashedPass);

        user.setPassword(hashedPass);

        User newUser = userRepository.save(user);

        return "Mam nowego użytkownika o id = " + newUser.getId();

    }*/

}
