package ind.learningSpring.service;

import ind.learningSpring.exceptions.UserAlreadyExistsException;
import ind.learningSpring.models.User;
import ind.learningSpring.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();

    }

    @Override
    public void signUp(User user) {
        user.setPassword( this.passwordEncoder.encode(user.getPassword()) );
        if(userRepository.existsByUsername(user.getUsername()) || userRepository.existsByEmail(user.getEmail()))
            throw new UserAlreadyExistsException();
        else
            userRepository.save(user);
    }
}
