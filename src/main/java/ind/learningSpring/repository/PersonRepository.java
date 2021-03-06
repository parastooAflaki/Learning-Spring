package ind.learningSpring.repository;

import ind.learningSpring.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    // select * from person where name = 'name'
    public Optional<Person> findByName(String name);
    public Person findByUsername(String username);

}
