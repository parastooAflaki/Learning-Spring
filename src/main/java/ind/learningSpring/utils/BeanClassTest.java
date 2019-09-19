package ind.learningSpring.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanClassTest {

    private int i = 0;

    public int plusI() {
        return i++;
    }
}
