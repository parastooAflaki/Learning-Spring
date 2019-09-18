package ind.learningSpring;

import org.springframework.hateoas.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
public class FirstController {

    private final BeanClassTest beanClassTest;
    private final PersonRepository personRepository;
    private final FirstService firstService;

    public FirstController(BeanClassTest beanClassTest,PersonRepository personRepository,FirstService firstService) {
        this.beanClassTest = beanClassTest;
        this.personRepository = personRepository;
        this.firstService = firstService;
    }

    @GetMapping("/hi")
    @ResponseBody
    public ResponseTest sayHi(){

        return new ResponseTest(beanClassTest.i++ , "salam") /*+ beanClassTest.i++ */ ;

    }

    @GetMapping("/persons/{id}")
    @ResponseBody
    public Resource<Person> getOne(@PathVariable Long id){

      return firstService.getOne(id);
    }

    @GetMapping("/persons")
    @ResponseBody
    public List<Person> getAll(){
        return firstService.getAll();
    }

    @PostMapping("/persons")
    @ResponseBody
    public void addPerson(@RequestBody Person p){
        System.out.println(personRepository.findByName(p.getName()));
        personRepository.save(p);


    }










}
