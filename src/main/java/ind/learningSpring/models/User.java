package ind.learningSpring.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    private String name;
    private String username;
    private String email;
    private String password;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;



}
