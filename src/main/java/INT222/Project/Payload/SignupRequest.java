package INT222.Project.Payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.Email;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
public class SignupRequest {


    private String firstname;

    private String lastname;

    private Date birth;

    private String gender;

    private String tel;

    private String username;

    @Email
    private String email;

    private Set<String> roles;

    private String password;


}
