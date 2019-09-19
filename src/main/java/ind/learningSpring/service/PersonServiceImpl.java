package ind.learningSpring.service;

import ind.learningSpring.models.Person;
import ind.learningSpring.PersonNotFound;
import ind.learningSpring.repository.PersonRepository;
import ind.learningSpring.controllers.FirstController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;


    @Override
    public List<Person> getAll(){
        List<Person> persons = new ArrayList<Person>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    @Override
    public Resource<Person> getOne(@PathVariable Long id){

        Optional<Person> person= personRepository.findById(id);
//        return person.orElseThrow(() -> new IllegalArgumentException());

        return new Resource<>( person.orElseThrow(()-> new PersonNotFound(id)) , linkTo( methodOn(FirstController.class).getAll()).withRel("all") , linkTo( methodOn( FirstController.class).getOne(id)).withSelfRel() );//roye obj gharar migirad va linke haro mitonam besh ezafe konam

    }

    @Override
    public void addPerson(@RequestBody Person p){
        System.out.println(personRepository.findByName(p.getName()));
        personRepository.save(p);


    }

}
