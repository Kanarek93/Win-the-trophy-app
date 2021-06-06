package canary.service;

import canary.domain.user.CurrentUser;
import canary.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SpringDataUserDetailService implements UserDetailsService {

    private UserService userService;

    @Autowired
    public void setUserRepository(UserServiceImpl us){
        this.userService = us;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findByUserName(s);
        if (user == null) {throw new UsernameNotFoundException(s); }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().forEach(r ->
                grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));
        return new CurrentUser(
                user.getName(), user.getPassword(),grantedAuthorities, user);
    }
}
