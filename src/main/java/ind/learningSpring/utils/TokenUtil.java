package ind.learningSpring.utils;

import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

public interface TokenUtil extends Serializable {

    public Optional<String> getUsernameFromToken(String token);
    public Date getExpirationDateFromToken(String token);
    public String generateToken(UserDetails userDetails);
    public Boolean validateToken( String token, UserDetails userDetails) ;

}
