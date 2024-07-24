package az.edu.turing.az.springboot04jdbc_template.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Profile {

    private UUID id;
    private String username;
    private int age;
    private Date created;
    private Date updated;
    private byte[] profilePhoto;
}
