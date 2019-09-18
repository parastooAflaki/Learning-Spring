package ind.learningSpring;

public class PersonNotFound extends RuntimeException {

    public PersonNotFound(Long id) {

        super("person with id "+id+" not Found!");
    }
}
