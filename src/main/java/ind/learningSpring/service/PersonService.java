package ind.learningSpring.service;

import ind.learningSpring.models.Person;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PersonService {

    public List<Person> getAll();
    public Resource<Person> getOne(@PathVariable Long id);
    public void addPerson(@RequestBody Person p);


}
