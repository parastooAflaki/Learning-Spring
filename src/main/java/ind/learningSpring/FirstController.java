package ind.learningSpring;

import org.springframework.hateoas.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Controller
public class FirstController {

    private final BeanClassTest beanClassTest;
    private final PersonService firstService;

    public FirstController(BeanClassTest beanClassTest, PersonServiceImpl personServiceImpl) {
        this.beanClassTest = beanClassTest;
        this.firstService = personServiceImpl;
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
        firstService.addPerson(p);


    }










}
