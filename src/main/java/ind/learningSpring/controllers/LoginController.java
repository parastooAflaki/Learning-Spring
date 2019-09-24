package ind.learningSpring.controllers;

import ind.learningSpring.service.UserDetailServiceImpl;
import ind.learningSpring.service.UserService;
import ind.learningSpring.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class LoginController {


    UserDetailsService userDetailsService;
    AuthenticationManager authenticationManager;
    TokenUtil tokenUtil;

    @Autowired
    public LoginController(UserDetailServiceImpl userDetailsService, AuthenticationManager authenticationManager, TokenUtil tokenUtil) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.tokenUtil = tokenUtil;
    }


    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> userpass) {
        String username = userpass.get("username");
        String password = userpass.get("pass");
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
        try {
           authenticationManager.authenticate(authentication);
        } catch (DisabledException e) {
            e.printStackTrace();
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(userpass.get("username"));

        return tokenUtil.generateToken(userDetails);


    }


}
