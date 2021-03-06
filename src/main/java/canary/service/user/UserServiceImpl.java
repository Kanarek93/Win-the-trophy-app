package canary.service.user;

import canary.controller.HomeController;
import canary.domain.team.Team;
import canary.domain.user.Role;
import canary.domain.user.User;
import canary.domain.user.UserDto;
import canary.domain.user.UserMapper;
import canary.repository.RoleRepository;
import canary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    private final UserMapper mapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


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
        Role userRole = roleRepository.findByName("ROLE_USER").orElse(saveRoleByName("ROLE_USER"));
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
        LOGGER.info("Zarejestrowałem użytkownika " + user.getName() + "o id = " + user.getId());
        return user;
    }

    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String name = authentication.getName();
            return findByUserName(name);
        }
        else {
            return new User();
        }
    }

    public User saveTeam(Team team){
        User current = getCurrentUser();
        current.setFavTeam(team);
        return userRepository.save(current);
    }

    private Role saveRoleByName(String name){
        Role toSave = new Role();
        toSave.setName(name);
        return  roleRepository.save(toSave);
    }

    private boolean emailAlreadyExist(String email){
        return  userRepository.findByEmail(email) != null;
    }


}
