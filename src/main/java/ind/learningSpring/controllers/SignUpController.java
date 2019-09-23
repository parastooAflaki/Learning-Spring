package ind.learningSpring.controllers;

import ind.learningSpring.models.User;
import ind.learningSpring.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public void signUp(@RequestBody User user){
        userService.signUp(user);
    }





}
