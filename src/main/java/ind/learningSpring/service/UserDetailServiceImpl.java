package ind.learningSpring.service;

import ind.learningSpring.models.Person;
import ind.learningSpring.repository.PersonRepository;
import ind.learningSpring.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    UserRepository userRepository;
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ind.learningSpring.models.User user = userRepository.findByUsername(username);
        return new User(user.getUsername() , user.getPassword() , new ArrayList<>());

    }
}
