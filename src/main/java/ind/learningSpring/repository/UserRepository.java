package ind.learningSpring.repository;

import ind.learningSpring.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

public boolean existsByUsername(String username);
public boolean existsByEmail(String email);
public User findByUsername(String username);

}
