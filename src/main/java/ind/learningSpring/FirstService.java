package ind.learningSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class FirstService {

    @Autowired
    private PersonRepository personRepository;



    public List<Person> getAll(){
        List<Person> persons = new ArrayList<Person>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    public Resource<Person> getOne(@PathVariable Long id){

        Optional<Person> person= personRepository.findById(id);
//        return person.orElseThrow(() -> new IllegalArgumentException());

        return new Resource<>( person.orElseThrow(()-> new PersonNotFound(id)) , linkTo( methodOn(FirstController.class).getAll()).withRel("all") , linkTo( methodOn( FirstController.class).getOne(id)).withSelfRel() );//roye obj gharar migirad va linke haro mitonam besh ezafe konam

    }

}
