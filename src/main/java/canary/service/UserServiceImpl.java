package canary.service;

import canary.controller.HomeController;
import canary.domain.user.Role;
import canary.domain.user.User;
import canary.domain.user.UserDto;
import canary.domain.user.UserMapper;
import canary.repository.RoleRepository;
import canary.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

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
    public User registerUser(UserDto userDto) {
        if (emailAlreadyExist(userDto.getEmail())){
            throw new IllegalArgumentException("There is an account with email: " + userDto.getEmail());
        }
        User user = mapper.userDtoToUser(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
        LOGGER.info("Zarejestrowałem użytkownika " + user.getName() + "o id = " + user.getId());
        return user;
    }

    private boolean emailAlreadyExist(String email){
        return  userRepository.findByEmail(email) != null;
    }


}
