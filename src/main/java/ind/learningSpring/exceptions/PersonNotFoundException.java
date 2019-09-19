package ind.learningSpring.exceptions;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(Long id) {

        super("person with id "+id+" not Found!");
    }
}
