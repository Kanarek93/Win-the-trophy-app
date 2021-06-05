package canary.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {

    private final canary.domain.User user;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       canary.domain.User user) {

        super(username, password, true, true, true, true, authorities);
        this.user = user;
    }

    public canary.domain.User getUser() {return user;}
    
}
