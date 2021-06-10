package canary.domain.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Collection;

public class CurrentUser extends User {

    private final canary.domain.user.User user;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       canary.domain.user.User user) {

        super(username, password, true, true, true, true, authorities);
        this.user = user;
    }

    public canary.domain.user.User getUser() {return user;}
    
}
