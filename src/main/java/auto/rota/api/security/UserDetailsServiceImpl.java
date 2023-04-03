package auto.rota.api.security;

import auto.rota.api.exception.EmptyEmailException;
import auto.rota.api.exception.UserNotFoundException;
import auto.rota.api.model.User;
import auto.rota.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) {

        User user = null;
        try {
            user = userService.readByEmail(email);
        } catch (UserNotFoundException | EmptyEmailException e) {
            throw new UsernameNotFoundException("Bad credentials");
        }

        return mapToUserDetails(user);
    }

    private org.springframework.security.core.userdetails.User mapToUserDetails(User user) {

        if (user.getIsAdmin()) {
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ADMIN")));
        } else {
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(), user.getPassword(), Collections.emptySet());
        }
    }
}
